function up(lstr){ // converte minusculas em maiusculas
var str=lstr.value; //obtem o valor
lstr.value=str.toUpperCase(); //converte as strings e retorna ao campo
}
function down(lstr){ // converte maiusculas em minusculas
var str=lstr.value; //obtem o valor
lstr.value=str.toLowerCase(); //converte as strings e retorna ao campo
}

/*abre janela padrão para excluir
 * o parametro 'a' é passado e aparecerá na janela msgdia.
 * */
function showMsg(a) { 
	msgdia.show();	
	document.getElementById('texto').innerHTML  =" "+ a+"?";
	document.title = a;//exibeo na barra do navegador o parametro passado

	} 



function  janela(a) {
	 return confirm(a);
}

function teste() {
	msgdia.show();
	
	
}
function mostra(){
	return  a = 'miguel mendes lopes';
}