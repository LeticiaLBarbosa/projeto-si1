// @SOURCE:C:/Users/PET/git/projeto-si1/FlowChartHelper/conf/routes
// @HASH:e6d04fc8420897b7e2242eea93e8c3b6932389c1
// @DATE:Fri Feb 28 13:54:28 GMT-03:00 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:16
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:16
class ReverseAssets {
    

// @LINE:16
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:9
def removeDisciplina(id:String, periodo:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "removeDisciplina/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/" + implicitly[PathBindable[Int]].unbind("periodo", periodo))
}
                                                

// @LINE:7
def adicionaPeriodo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "adicionaPeriodo")
}
                                                

// @LINE:12
// @LINE:11
// @LINE:10
def planejando(message:String): Call = {
   (message: @unchecked) match {
// @LINE:10
case (message) if true => Call("GET", _prefix + { _defaultPrefix } + "planejando/" + implicitly[PathBindable[String]].unbind("message", dynamicString(message)))
                                                        
// @LINE:11
case (message) if message == "" => Call("GET", _prefix + { _defaultPrefix } + "planejando/")
                                                        
// @LINE:12
case (message) if message == "" => Call("GET", _prefix + { _defaultPrefix } + "planejando")
                                                        
   }
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:8
def adicionaDisciplina(id:String, periodo:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "adicionaDisciplina/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/" + implicitly[PathBindable[Int]].unbind("periodo", periodo))
}
                                                
    
}
                          
}
                  


// @LINE:16
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:16
class ReverseAssets {
    

// @LINE:16
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:9
def removeDisciplina : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.removeDisciplina",
   """
      function(id,periodo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "removeDisciplina/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo)})
      }
   """
)
                        

// @LINE:7
def adicionaPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.adicionaPeriodo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adicionaPeriodo"})
      }
   """
)
                        

// @LINE:12
// @LINE:11
// @LINE:10
def planejando : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.planejando",
   """
      function(message) {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "planejando/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("message", encodeURIComponent(message))})
      }
      if (message == """ + implicitly[JavascriptLitteral[String]].to("") + """) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "planejando/"})
      }
      if (message == """ + implicitly[JavascriptLitteral[String]].to("") + """) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "planejando"})
      }
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:8
def adicionaDisciplina : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.adicionaDisciplina",
   """
      function(id,periodo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adicionaDisciplina/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:16
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:16
class ReverseAssets {
    

// @LINE:16
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:9
def removeDisciplina(id:String, periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.removeDisciplina(id, periodo), HandlerDef(this, "controllers.Application", "removeDisciplina", Seq(classOf[String], classOf[Int]), "GET", """""", _prefix + """removeDisciplina/$id<[^/]+>/$periodo<[^/]+>""")
)
                      

// @LINE:7
def adicionaPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.adicionaPeriodo(), HandlerDef(this, "controllers.Application", "adicionaPeriodo", Seq(), "GET", """""", _prefix + """adicionaPeriodo""")
)
                      

// @LINE:10
def planejando(message:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.planejando(message), HandlerDef(this, "controllers.Application", "planejando", Seq(classOf[String]), "GET", """""", _prefix + """planejando/$message<[^/]+>""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:8
def adicionaDisciplina(id:String, periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.adicionaDisciplina(id, periodo), HandlerDef(this, "controllers.Application", "adicionaDisciplina", Seq(classOf[String], classOf[Int]), "GET", """""", _prefix + """adicionaDisciplina/$id<[^/]+>/$periodo<[^/]+>""")
)
                      
    
}
                          
}
        
    