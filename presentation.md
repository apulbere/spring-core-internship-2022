---
marp: true
html: true
theme: default
footer: "Endava Spring Internship 2022"
class:
  - invert
style: |
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap');
  * {
    font-family: 'Roboto', sans-serif;
  }
  footer {
    text-align: right;
    width: 95%;
  }
---

# Spring Core
###### Adrian Pulbere | adrian.md
###### April 2022

---

# Content

* Spring IoC container
* Bean
* Bean Scope
* Injection methods

---

# Spring IoC container

* IoC is also known as dependency injection (DI)
* BeanFactory and ApplicationContext
* ApplicationContext is a sub-interface of BeanFactory. It adds easier integration with Spring's AOP features.

---

#### Application context
* Bean factory methods for accessing application components
* The ability to load file resources in a generic fashion
* The ability to publish events to registered listeners
* The ability to resolve messages, supporting i18n.

##### How to configure:
* Xml
* Annotation

---

# Bean

A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.

---

# Bean scope

* singleton - (Default) Scopes a single bean definition to a single object instance per Spring IoC container.
* prototype - Scopes a single bean definition to any number of object instances.
* request - Scopes a single bean definition to the lifecycle of a single HTTP request
* session - Scopes a single bean definition to the lifecycle of an HTTP Session
* global session - Scopes a single bean definition to the lifecycle of a global HTTP Session
* custom