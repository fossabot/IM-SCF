=======
# IM-SCF
Reverse IM-SSF implementation on top of RestComm jSS7

With the help of IM-SCF (Reverse IM-SSF) the existing subscriber base of the network operators can access voice services implemented in SIP application servers such as Restcomm SIP Servlets. It means that the network operator is able to use a common and converged SIP application server-hosted voice application platform for both SS7 and IMS network. 
The IM-SCF implements a protocol conversion logic between the traditional IN and IMS: IN protocols such as CAMEL generated by the network are converted to SIP and routed to a SIP application acting as SCF.

Build imscf-common first then imscf-el and imscf-sl with Maven. Build currently works only with Alerant's internal Nexus repository. 
