
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
                    DATE: Tue Feb 25 21:40:35 GMT-03:00 2014
                    SOURCE: C:/Users/Leticia/Documents/SI1/lab3si/FlowChartHelper/app/views/index.scala.html
                    HASH: eb3f2a9f43f030ad092ebfbdcef7f35296b6f2ab
                    MATRIX: 791->1|946->45|974->65|1011->68|1044->93|1083->95|1122->100|1152->122|1190->123|1423->320|1452->327|1503->347|1560->369|1611->411|1651->413|1754->483|1861->555|1920->598|1960->600|2104->708|2127->709|2174->720|2190->727|2227->742|2289->769|2346->817|2385->818|2592->989|2608->996|2672->1037|2738->1072|2833->1131|2856->1132|2952->1193|3012->1237|3051->1238|3101->1252|3120->1262|3152->1272|3237->1321|3256->1331|3287->1339|3327->1342|3351->1343|3409->1364|3429->1374|3466->1388|3538->1429|3620->1480|3727->1552|3797->1606|3836->1607|3890->1625|3909->1635|3939->1643|4007->1675|4026->1685|4058->1695|4212->1812|4232->1822|4265->1832|4316->1846|4336->1856|4373->1870|4442->1908|4495->1930
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|39->11|39->11|42->14|44->16|44->16|44->16|44->16|49->21|49->21|49->21|54->26|54->26|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|60->32|62->34|62->34|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|66->38|72->44|83->55|83->55|83->55|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|85->57|90->62
                    -- GENERATED --
                */
            