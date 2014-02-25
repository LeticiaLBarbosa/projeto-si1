function allowDrop(ev){
	ev.preventDefault();
}
function drag(ev){
	ev.dataTransfer.setData("Nome", event.target.dataset.value);
	ev.dataTransfer.setData("ID", event.target.id);
	ev.dataTransfer.effectAllowed = 'move';

}
function dismiss(){
	document.getElementById('alerta').style.visibility = "hidden"
	
	document.location.href = "/planejando"
}

function retorna(event, id, periodo){
	event.target.parentNode.parentNode.removeChild(event.target.parentNode);
	document.location.href = "/removeDisciplina/"+id+"/"+periodo 
}

function drop(ev){
	ev.preventDefault();
	var data = ev.dataTransfer.getData("Nome");
	var id = ev.dataTransfer.getData("ID");
	var periodo = event.target.dataset.value
	document.location.href = "/adicionaDisciplina/"+id+"/"+periodo
	document.getElementById(id).parentNode.removeChild(document.getElementById(id));
}