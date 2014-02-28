
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[FlowChartManager,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(manager: FlowChartManager, message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.46*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main("Flow Chart Helper")/*4.27*/ {_display_(Seq[Any](format.raw/*4.29*/("""

"""),_display_(Seq[Any](/*6.2*/if(!message.isEmpty())/*6.24*/{_display_(Seq[Any](format.raw/*6.25*/("""
<div id="alerta"></div>
<div id="alerta-message">
	<div class="alert">
  <button type="button" class="close" data-dismiss="alert" onclick="dismiss()">×</button>
  <strong>Problema!</strong> """),_display_(Seq[Any](/*11.31*/message)),format.raw/*11.38*/("""
	</div>
</div>
""")))})),format.raw/*14.2*/("""
<div id="barra"> 
"""),_display_(Seq[Any](/*16.2*/form(routes.Application.adicionaPeriodo())/*16.44*/ {_display_(Seq[Any](format.raw/*16.46*/("""<input class="btn btn-large" type="submit" value="Adicionar periodo">""")))})),format.raw/*16.116*/("""
</div>
<div id="periodos"> <center>
<ul class="thumbnails">
  
  """),_display_(Seq[Any](/*21.4*/for(i <- 1 to manager.getTotalDePeriodos()) yield /*21.47*/ {_display_(Seq[Any](format.raw/*21.49*/("""
  
  
  <li class="span4">
    <div class="thumbnail">
    <div  id="internal-div-title"><h4>Período """),_display_(Seq[Any](/*26.48*/i)),format.raw/*26.49*/("""</h4> com """),_display_(Seq[Any](/*26.60*/manager/*26.67*/.getCreditos(i))),format.raw/*26.82*/(""" créditos no momento
    """),_display_(Seq[Any](/*27.6*/if(manager.verificaMinimoDeCreditosDoPeriodo(i))/*27.54*/{_display_(Seq[Any](format.raw/*27.55*/("""
     <div class="alert">
  <button type="button" class="close" data-dismiss="alert">×</button>
  <strong>Créditos Insuficientes!</strong> Você precisa adicionar mais """),_display_(Seq[Any](/*30.73*/manager/*30.80*/.verificaQuantosCreditosFaltaNoPeriodo(i))),format.raw/*30.121*/("""
 cŕeditos a este período</div>
""")))})),format.raw/*32.2*/("""
</div>
     <div  id="internal-div" data-value="periodo"""),_display_(Seq[Any](/*34.50*/i)),format.raw/*34.51*/("""" ondrop="drop(event)" ondragover="allowDrop(event)">
     """),_display_(Seq[Any](/*35.7*/for(disciplina <- manager.getDisciplinas(i)) yield /*35.51*/{_display_(Seq[Any](format.raw/*35.52*/("""
     	<pre>"""),_display_(Seq[Any](/*36.13*/disciplina/*36.23*/.getNome())),format.raw/*36.33*/(""" <i class="icon-remove" onclick="retorna(event, """),_display_(Seq[Any](/*36.82*/disciplina/*36.92*/.getId())),format.raw/*36.100*/(""", """),_display_(Seq[Any](/*36.103*/i)),format.raw/*36.104*/(""")"></i> <br><small>("""),_display_(Seq[Any](/*36.125*/disciplina/*36.135*/.getCreditos())),format.raw/*36.149*/(""" créditos)</small></pre>
     	
     	""")))})),format.raw/*38.8*/("""
     </div>
      
    </div>
  </li>
  
  """)))})),format.raw/*44.4*/("""
  

  
  
</ul>

</div>

<div id="catalogo">
<ul id="opa">
"""),_display_(Seq[Any](/*55.2*/for(disciplina <- manager.getDisciplinasDisponiveis()) yield /*55.56*/{_display_(Seq[Any](format.raw/*55.57*/("""
		<li><div id=""""),_display_(Seq[Any](/*56.17*/disciplina/*56.27*/.getId())),format.raw/*56.35*/("""" draggable="true" data-value=""""),_display_(Seq[Any](/*56.67*/disciplina/*56.77*/.getNome())),format.raw/*56.87*/("""" ondragstart="drag(event)" ondragend="clear(event)" ondragleave="clear(event)"  class="btn btn-primary btn-medium">"""),_display_(Seq[Any](/*56.204*/disciplina/*56.214*/.getNome())),format.raw/*56.224*/(""" <br><small>("""),_display_(Seq[Any](/*56.238*/disciplina/*56.248*/.getCreditos())),format.raw/*56.262*/(""" créditos)</small></div></li>
     	""")))})),format.raw/*57.8*/("""
</ul>
</div>


""")))})),format.raw/*62.2*/("""
"""))}
    }
    
    def render(manager:FlowChartManager,message:String): play.api.templates.HtmlFormat.Appendable = apply(manager,message)
    
    def f:((FlowChartManager,String) => play.api.templates.HtmlFormat.Appendable) = (manager,message) => apply(manager,message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Feb 28 13:54:29 GMT-03:00 2014
                    SOURCE: C:/Users/PET/git/projeto-si1/FlowChartHelper/app/views/index.scala.html
                    HASH: 4a6cfc295c6fc6907e8af913b09fc82c2826a3b0
                    MATRIX: 791->1|945->45|972->63|1008->65|1041->90|1080->92|1117->95|1147->117|1185->118|1413->310|1442->317|1490->334|1545->354|1596->396|1636->398|1739->468|1841->535|1900->578|1940->580|2079->683|2102->684|2149->695|2165->702|2202->717|2263->743|2320->791|2359->792|2563->960|2579->967|2643->1008|2707->1041|2800->1098|2823->1099|2918->1159|2978->1203|3017->1204|3066->1217|3085->1227|3117->1237|3202->1286|3221->1296|3252->1304|3292->1307|3316->1308|3374->1329|3394->1339|3431->1353|3501->1392|3577->1437|3673->1498|3743->1552|3782->1553|3835->1570|3854->1580|3884->1588|3952->1620|3971->1630|4003->1640|4157->1757|4177->1767|4210->1777|4261->1791|4281->1801|4318->1815|4386->1852|4434->1869
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|39->11|39->11|42->14|44->16|44->16|44->16|44->16|49->21|49->21|49->21|54->26|54->26|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|60->32|62->34|62->34|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|66->38|72->44|83->55|83->55|83->55|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|85->57|90->62
                    -- GENERATED --
                */
            