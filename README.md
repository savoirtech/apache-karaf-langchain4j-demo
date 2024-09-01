# Apache Karaf LangChain4J Application Demo

In this demo we’ll build an [API Gateway
Service](https://microservices.io/patterns/apigateway.html) which allows
our users to utilize various Generative API services.

To implement this pattern we’ll use [Apache
Karaf](https://karaf.apache.org/) as our runtime container, [Apache
CXF](https://cxf.apache.org/) as our JAX-RS webservice implementation,
Savoirtech’s [EOS library](https://github.com/savoirtech/eos) to
implement a Keyed-Whiteboard plugin-architecture, and
[LangChain4J](https://docs.langchain4j.dev/) to integrate various
Generative API Services.

## Architecture Overview:

When working with microservices we implement an API Gateway Service to
simplify clients accessing many down stream services via a single entry
point. This service can then either directly proxy to a requested
service, or handle the orchestration of multiple services required for
the call.

A Keyed-Whiteboard plugin architecture allows developers to encapsulate
specific functionality into discrete deployable units of code. In our
demo we will assign each plugin a specific Generative AI service to
provide services upon. Our end users will only need to know which plugin
they desire to use, but not the specifics (or API KEYS) to use them. In
Enterprise development teams, this leads to an expert group being able
to manage these assets in a consistent manner.

LangChain4J eases interaction with LLMs and Vector Stores, providing a
toolbox for common LLM operations. Utilizing LangChain4J we can
implement plugin logic for prompt templating, chat memory management,
output parsing, or higher level patterns such as AI Service and
Retrieval Augmented Generation (RAG).

Our modular architecture is deployed via an Apache Karaf Feature
descriptor. Here our developers can manage the dependencies of the
overall application, ensuring a smooth runtime experience. Our itests
module contains KarafTestSupport to help automate wiring testing.

## Installation:

``` bash
feature:repo-add mvn:com.savoir/application-features-file/1.0.0-SNAPSHOT/xml/features
feature:install application-all-demo
```

## Verify Installation:

``` bash
karaf@root()> list
START LEVEL 100 , List Threshold: 50
 ID │ State  │ Lvl │ Version        │ Name
────┼────────┼─────┼────────────────┼────────────────────────────────────────────────────────────────────────────────────
 33 │ Active │  80 │ 4.4.6          │ Apache Karaf :: OSGi Services :: Event
106 │ Active │  85 │ 1.0.0.SNAPSHOT │ Apache-Karaf-LangChain4J-AI-DEMO :: api
107 │ Active │  85 │ 1.0.0.SNAPSHOT │ Apache-Karaf-LangChain4J-AI-DEMO :: impl
108 │ Active │  85 │ 1.0.0.SNAPSHOT │ Apache-Karaf-LangChain4J-AI-DEMO :: plugins
109 │ Active │  85 │ 1.0.0.SNAPSHOT │ Apache-Karaf-LangChain4J-AI-DEMO :: spi
110 │ Active │  80 │ 2.10.1         │ Gson
111 │ Active │  80 │ 18.0.0         │ Guava: Google Core Libraries for Java
112 │ Active │  80 │ 1.1.0          │ SavoirTech :: Eos :: Core
120 │ Active │  80 │ 3.4.0          │ Apache Commons Lang
128 │ Active │  80 │ 0              │ wrap_file__Users_jgoodyear_.m2_repository_com_knuddels_jtokkit_1.1.0_jtokkit-1.1.0.jar
karaf@root()>
```

### Verify webservice available:

``` bash
http://localhost:8181/cxf/
```

### Test our webservice:

``` bash
curl --location --request POST 'http://0.0.0.0:8181/cxf/ai' \
--header 'Content-Type: application/json' \
--data-raw '
{
  "id": 1234567890,
  "sku": "demo",
  "quantity": 1
}'
```

``` bash
{"description":"This is a demo plugin."}
```
