#python -m SimpleHTTPServer  para servers simples
from SOAPpy import SOAPServer
def hello():
    return "Hello World"
server = SOAPpy.SOAPServer(("localhost", 8080))
server.registerFunction(hello)
server.serve_forever()