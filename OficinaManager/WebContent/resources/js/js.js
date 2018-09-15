function up(lstr){ // converte minusculas em maiusculas
var str=lstr.value; //obtem o valor
lstr.value=str.toUpperCase(); //converte as strings e retorna ao campo
}
function down(lstr){ // converte maiusculas em minusculas
var str=lstr.value; //obtem o valor
lstr.value=str.toLowerCase(); //converte as strings e retorna ao campo
}

/*abre janela padr�o para excluir
 * o parametro 'a' � passado e aparecer� na janela msgdia.
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

PrimeFaces.locales['pt'] = {  
        closeText: 'Fechar',  
        prevText: 'Anterior',  
        nextText: 'Próximo',  
        currentText: 'Começo',  
        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],  
        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],  
        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],  
        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'],  
        dayNamesMin: ['D','S','T','Q','Q','S','S'],  
        weekHeader: 'Semana',  
        firstDay: 1,  
        isRTL: false,  
        showMonthAfterYear: false,  
        yearSuffix: '',  
        timeOnlyTitle: 'Só Horas',  
        timeText: 'Tempo',  
        hourText: 'Hora',  
        minuteText: 'Minuto',  
        secondText: 'Segundo',  
        currentText: 'Data Atual',  
        ampm: false,  
        month: 'Mês',  
        week: 'Semana',  
        day: 'Dia',  
        allDayText : 'Todo Dia'  
    };