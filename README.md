# ravelin-java

Java library which helps integrate your Java application to Ravelin, a fraud detection tool. (https://www.ravelin.com/).

Installation (using Maven)
-

_There is no deployed artefacts at the time of writing_ so you have to build it yourself. Fork the repository and run `mvn install`.

_Apache Maven 3+ is required to build the artefact._

How to use
-

#### What it does:
Serialize and deserialize Ravelin Java classes to JSON format String and vice-versa.

#### What it doesn't do:
Send the request to Ravelin itself. This was not integrated to the library purely because your application might already have an implementing client (like Jersey, RestEasy) which one could use—adding an in-built client is highly opinionated and might cause classloading issues.

Refer to _Sending a Request Using RestEasy v2.x_ below for a client example.

#### Some examples

Create Customer
```
Location location = new Location("James St", null, null, null, "Darwen", "Blackburn with Darwen", "GBR", null, "BB3 1AS", 53.697471d, -2.470891d, null);

Customer customer = new Customer("61283761287361",
                                       1429029731,
                                       null,
                                       "Mark",
                                       "Twain",
                                       null,
                                       null,
                                       "marktwain@gmail.com",
                                       null,
                                       "mtwain",
                                       null,
                                       null,
                                       null,
                                       location,
                                       null,
                                       "lon");

customer.addCustom("newsletter", false);
customer.addCustom("invitedBy", "7198737117");

CustomerEvent event = new CustomerEvent(1429029735, null, customer, null);
String $customer_json = event.toJSON(); // serializing the request, ready for Ravelin
```

Pre-Transaction Event
```
   PreTransaction preTransaction = new PreTransaction("f61f8594e06459fa046707c36159bb35", "james.tate@gmail.com", "GBP", 4675, 0, null, TransactionType.AUTH, null);
   PreTransactionEvent event = new PreTransactionEvent(1429029735, "61283761287361", null, null, "783917", "n1QSYK0ceGNZqU28ien3", preTransaction, null, null);
   String $pretransaction_json = event.toJSON(); // serializing the request, ready for Ravelin
```

Label Customer
```
Reviewer reviewer = new Reviewer("Bilbo Baggins", "bilbo.b@shiremail.com");
LabelCustomerEvent event = new LabelCustomerEvent("customer1", Label.GENUINE, "This customer called up and we have determined he is not a fraudster", reviewer);

String $label_json = event.toJSON(); // serializing the request, ready for Ravelin
```

Deserializing an HTTP response:
```
String $response = // fetch response from your client
RavelinResponse response = RavelinResponse.parse(responseContent);
```

Sending a Request Using RestEasy v2.x
-

```
protected static RavelinResponse send(String url, String apiKey, String json, boolean getScore) throws RavelinException, IOException {

        HttpResponse response;
        String responseContent;
        {
            HttpClient client = HttpClientBuilder.create().setHostnameVerifier(new AllowAllHostnameVerifier()).build();

            final URI uri;
            try {
                uri = new URIBuilder(url).addParameter("score", Boolean.toString(getScore)).build();
            } catch (URISyntaxException e) {
                throw new RuntimeException("An error has occured while trying to generate the request URI", e);
            }
            HttpPost request = new HttpPost(uri);
            request.addHeader("Authorization", format("token %s", apiKey));
            request.addHeader("Accept", ContentType.APPLICATION_JSON.getMimeType());
            request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

            response = client.execute(request);
            List<String> contentLineList = IOUtils.readLines(response.getEntity().getContent());
            responseContent = contentLineList.stream().reduce("", (a, b) -> a + '\n' + b);
        }

        final RavelinResponse ravelinResponse;
        {
            final RavelinStatusCode ravelinResponseCode = RavelinStatusCode.resolve(response.getStatusLine().getStatusCode());
            switch (ravelinResponseCode) {
                case OK:
                    ravelinResponse = RavelinResponse.parse(responseContent);
                    break;
                default:
                    throw new RavelinException(ravelinResponseCode,
                                               format("Http error response received from Ravelin when trying to attempt to send json [%s] to URL [%s] - [%s]",
                                                      json,
                                                      url,
                                                      responseContent));
            }
        }

        return ravelinResponse;
    }
```

License
---
The MIT License (MIT)

Copyright (c) 2016 Matthew Cachia

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
