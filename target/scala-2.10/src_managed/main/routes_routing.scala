// @SOURCE:C:/Users/Leticia/Documents/SI1/projeto-si1/conf/routes
// @HASH:6a5d09b9c2f58f16bdeb4904f5439319027066ed
// @DATE:Tue Feb 25 23:08:39 GMT-03:00 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_adicionaPeriodo1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("adicionaPeriodo"))))
        

// @LINE:8
private[this] lazy val controllers_Application_adicionaDisciplina2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("adicionaDisciplina/"),DynamicPart("id", """[^/]+""",true),StaticPart("/"),DynamicPart("periodo", """[^/]+""",true))))
        

// @LINE:9
private[this] lazy val controllers_Application_removeDisciplina3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("removeDisciplina/"),DynamicPart("id", """[^/]+""",true),StaticPart("/"),DynamicPart("periodo", """[^/]+""",true))))
        

// @LINE:10
private[this] lazy val controllers_Application_planejando4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("planejando/"),DynamicPart("message", """[^/]+""",true))))
        

// @LINE:11
private[this] lazy val controllers_Application_planejando5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("planejando/"))))
        

// @LINE:12
private[this] lazy val controllers_Application_planejando6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("planejando"))))
        

// @LINE:16
private[this] lazy val controllers_Assets_at7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """adicionaPeriodo""","""controllers.Application.adicionaPeriodo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """adicionaDisciplina/$id<[^/]+>/$periodo<[^/]+>""","""controllers.Application.adicionaDisciplina(id:String, periodo:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """removeDisciplina/$id<[^/]+>/$periodo<[^/]+>""","""controllers.Application.removeDisciplina(id:String, periodo:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """planejando/$message<[^/]+>""","""controllers.Application.planejando(message:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """planejando/""","""controllers.Application.planejando(message:String = "")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """planejando""","""controllers.Application.planejando(message:String = "")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_adicionaPeriodo1(params) => {
   call { 
        invokeHandler(controllers.Application.adicionaPeriodo(), HandlerDef(this, "controllers.Application", "adicionaPeriodo", Nil,"GET", """""", Routes.prefix + """adicionaPeriodo"""))
   }
}
        

// @LINE:8
case controllers_Application_adicionaDisciplina2(params) => {
   call(params.fromPath[String]("id", None), params.fromPath[Int]("periodo", None)) { (id, periodo) =>
        invokeHandler(controllers.Application.adicionaDisciplina(id, periodo), HandlerDef(this, "controllers.Application", "adicionaDisciplina", Seq(classOf[String], classOf[Int]),"GET", """""", Routes.prefix + """adicionaDisciplina/$id<[^/]+>/$periodo<[^/]+>"""))
   }
}
        

// @LINE:9
case controllers_Application_removeDisciplina3(params) => {
   call(params.fromPath[String]("id", None), params.fromPath[Int]("periodo", None)) { (id, periodo) =>
        invokeHandler(controllers.Application.removeDisciplina(id, periodo), HandlerDef(this, "controllers.Application", "removeDisciplina", Seq(classOf[String], classOf[Int]),"GET", """""", Routes.prefix + """removeDisciplina/$id<[^/]+>/$periodo<[^/]+>"""))
   }
}
        

// @LINE:10
case controllers_Application_planejando4(params) => {
   call(params.fromPath[String]("message", None)) { (message) =>
        invokeHandler(controllers.Application.planejando(message), HandlerDef(this, "controllers.Application", "planejando", Seq(classOf[String]),"GET", """""", Routes.prefix + """planejando/$message<[^/]+>"""))
   }
}
        

// @LINE:11
case controllers_Application_planejando5(params) => {
   call(Param[String]("message", Right(""))) { (message) =>
        invokeHandler(controllers.Application.planejando(message), HandlerDef(this, "controllers.Application", "planejando", Seq(classOf[String]),"GET", """""", Routes.prefix + """planejando/"""))
   }
}
        

// @LINE:12
case controllers_Application_planejando6(params) => {
   call(Param[String]("message", Right(""))) { (message) =>
        invokeHandler(controllers.Application.planejando(message), HandlerDef(this, "controllers.Application", "planejando", Seq(classOf[String]),"GET", """""", Routes.prefix + """planejando"""))
   }
}
        

// @LINE:16
case controllers_Assets_at7(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     