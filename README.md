
 Apache Karaf Application Demo Lab
 ==================================

```
karaf@root()> list
START LEVEL 100 , List Threshold: 50
ID │ State  │ Lvl │ Version        │ Name
────┼────────┼─────┼────────────────┼────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
33 │ Active │  80 │ 4.4.6          │ Apache Karaf :: OSGi Services :: Event
120 │ Active │  80 │ 2.1.99.b01     │ javax.ws.rs-api
129 │ Active │  80 │ 1.0.0.SNAPSHOT │ Apache-Karaf-LangChain4J-AI-DEMO :: karaf-feature-project-api
130 │ Active │  80 │ 1.0.0.SNAPSHOT │ Apache-Karaf-LangChain4J-AI-DEMO :: karaf-feature-project-spi
132 │ Active │  80 │ 1.0.0.SNAPSHOT │ Apache-Karaf-LangChain4J-AI-DEMO :: karaf-feature-project-impl
134 │ Active │  80 │ 0              │ wrap_mvn_dev.langchain4j_langchain4j-open-ai_0.33.0
136 │ Active │  80 │ 0              │ wrap_mvn_dev.langchain4j_langchain4j-core_0.33.0
137 │ Active │  80 │ 1.1.0          │ SavoirTech :: Eos :: Core
138 │ Active │  80 │ 18.0.0         │ Guava: Google Core Libraries for Java
139 │ Active │  80 │ 3.4.0          │ Apache Commons Lang
140 │ Active │  80 │ 0              │ wrap_mvn_dev.langchain4j_langchain4j_0.33.0
145 │ Active │  80 │ 0              │ wrap_mvn_dev.langchain4j_langchain4j-embeddings-all-minilm-l6-v2_0.33.0
154 │ Active │  80 │ 2.10.1         │ Gson
156 │ Active │  80 │ 0              │ wrap_mvn_com.knuddels_jtokkit_1.1.0
170 │ Active │  80 │ 1.0.0.SNAPSHOT │ Apache-Karaf-LangChain4J-AI-DEMO :: karaf-feature-project-plugins
```

Fix CXF:
```
system:property javax.ws.rs.ext.RuntimeDelegate org.apache.cxf.jaxrs.impl.RuntimeDelegateImpl
```

 In this lab we introduce you to a good project layout
 which takes advantage of using a features file.

 Installation:
```
 feature:repo-add mvn:com.savoir/application-features-file/1.0.0-SNAPSHOT/xml/features
 feature:install application-all-demo
```
 Verify webservice:
```
 http://localhost:8181/cxf/
```
 Test:
```
curl --location --request POST 'http://0.0.0.0:8181/cxf/ai' \
--header 'Content-Type: application/json' \
--data-raw '
{
  "id": 1234567890,
  "sku": "demo",
  "quantity": 1
}'
{"description":"This is a demo plugin."}
```

============================================

If you don't install (modify features file to observe behavoir)
```
 feature:install cxf-core
 feature:install cxf-jaxrs
 ```
You'll see:

```
karaf@root()> diag 53
karaf-application-lab :: karaf-feature-project-impl (53)
--------------------------------------------------------
Status: GracePeriod
Blueprint
2022-09-25, 8:15 p.m.
Missing dependencies:
(&(objectClass=org.apache.aries.blueprint.NamespaceHandler)(osgi.service.blueprint.namespace=http://cxf.apache.org/blueprint/core)) (&(objectClass=org.apache.aries.blueprint.NamespaceHandler)(osgi.service.blueprint.namespace=http://cxf.apache.org/blueprint/jaxrs))
```
