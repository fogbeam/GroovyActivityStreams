An implementation of the [ActivityStrea.ms protocol](http://activitystrea.ms/) in Groovy.  Used by
[Quoddy](https://github.com/fogbeam/Quoddy) and [Neddick](https://github.com/fogbeam/Neddick) for sending and 
receiving activity stream events.  Note that this is not a complete implementation at this time and has NOT 
been extensively tested for interoperability with other implementations.

This will continue to evolve along with Quoddy and Neddick.  Pull requests are welcome, of course.


An example Groovy program is available under src/examples which shows how to use the API to post
a JSON representation of an ActivityStrea.ms event to a URL.  This example uses Spring's RestTemplate
and Jackson to handle the marshalling to JSON.  As far as interop goes, we've tested sending using
Spring/Jackson in a standalone program on the send side, and receiving using Grails and the JAX-RS plugin (with these classes), 
and everything worked seamlessly.  We have not yet tested interoperability with other implementations of ActivityStrea.ms 
however, but the raw JSON looks correct for the limited scenarios we support so far, and should work.

Also note that you can use this with a JAXB marshaller on the send side, marshall the classes to XML instead
of JSON, and - as long as you are sending to a process with a compatible JAXB implementation and these same
classes availabe - communicate using XML on the wire instead of JSON.  The norm for ActivityStrea.ms is really
JSON though, and interoperability with 3rd parties would basically require that.  Only use XML where you
control both ends of the exchange and really need XML for some reason. 

Note also that this is not the same thing as the Atom / XML serialization for which there is a spec.  We'll add "proper" Atom/XML support later (or accept a pull request if somebody else wants to do it).


Licensed under the Apache License V2.
Copyright (c) 2013, Fogbeam Labs