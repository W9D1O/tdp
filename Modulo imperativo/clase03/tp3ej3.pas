program tp3ej3;


const
	finDia = 31;
	finMes = 12;
	finAnio = 2100;
	finNota = 10;
	maxLeg = 500;
	maxcod = 250; //Codigo de materia.
type
	dias = 1..finDia;
	meses = 1..finMes;
	anios = 1940..finAnio;
	notas = 1..finNota;

Tfecha = record
	dia:dias;
	mes:meses;
	anio:anios;
	end;

Tfinal = record
	cod:integer;
	fecha:Tfecha;
	nota:notas;
	end;


lis = ^LNodo;

LNodo = record
	final: Tfinal;
	sig :lis;
	end;

TAlumno = record
	leg : integer;
	Lista:lis;
	end;
	

Arbol = ^ANodo;

ANodo = record
	datos:TAlumno;
	HD:Arbol;
	HI:Arbol
	end;
	
	
procedure LeerDatos(var datos:TFinal;var leg:integer);
begin
	leg := random(maxLeg + 1);
	datos.cod := random(maxcod) + 1;
	datos.nota := random(finNota) + 1;
	datos.fecha.dia := random(finDia) + 1;
	datos.fecha.mes := random(finMes) + 1;
	datos.fecha.anio := random(finAnio) + 1;

end;	


function adelante(l:lis;datos:TFinal):lis;
var
	aux:lis;
begin
	new(aux);
	aux^.final:= datos;
	aux^.sig:= l;
	adelante:= aux;
end;

procedure InsertarNodo(var a:arbol;datos:TFinal;leg:integer);
begin
	if(a = nil)then begin
		new(a);
		a^.datos.leg:= leg;
		a^.datos.Lista:= nil;
		a^.datos.Lista:= adelante(a^.datos.Lista,datos);
		a^.HD:=nil;
		a^.HI:= nil;
		end
			else
				if(leg = a^.datos.leg)then
					a^.datos.Lista:= adelante(a^.datos.Lista,datos)
				else
					if(leg > a^.datos.leg)then
						InsertarNodo(a^.HD,datos,leg)
					else
						InsertarNodo(a^.HI,datos,leg);

end;


procedure GenerarArbol(var a:arbol);
var
	leg:integer;
	datos:TFinal;
begin
	LeerDatos(datos,leg);
	if(leg <> 0)then begin
		InsertarNodo(a,datos,leg);
		GenerarArbol(a);
		end;
end;
	

procedure ImpArbol(a:arbol);
begin
	if(a <> nil)then begin
		ImpArbol(a^.HI);
		writeln(a^.datos.leg);
		ImpArbol(a^.HD)
		end;
end;


function LegImpar(a:arbol):integer;
	function Impar(leg:integer):boolean;
		begin
			Impar:= leg mod 2 <> 0;
		end;
	procedure ActImpar(a:arbol;var cont:integer);
	begin
			if(a <> nil)then
					if(Impar(a^.datos.leg))then begin
						cont := cont + 1;
						ActImpar(a^.HD,cont);
						ActImpar(a^.HI,cont)
						end
					else begin
						ActImpar(a^.HD,cont);
						ActImpar(a^.HI,cont);
						end;
	end;					
var
	cont:integer;
begin
	cont:= 0;
	ActImpar(a,cont);
	LegImpar:= cont;
end;						
	

procedure ImpFinalesAprobados(a:arbol);
	function CantAprobados(l:lis):integer;
	begin
		if(l = nil)then
			CantAprobados:= 0
			else
				if(l^.final.nota > 3)then
					CantAprobados:= CantAprobados(l^.sig) + 1
				else
					CantAprobados:= CantAprobados(l^.sig);
	end;

begin
	if(a <> nil)then begin
		ImpFinalesAprobados(a^.HI);
		writeln(a^.datos.leg,' ',CantAprobados(a^.datos.Lista));
		ImpFinalesAprobados(a^.HD);
		end;
end;


procedure ImpPromedio(a:arbol;prom:real);
	function CalcPromedio(l:lis):real;
		procedure RecoLis(l:lis;var cant,acu:integer);
		begin
			if(l <> nil)then begin
				cant:= cant + 1;
				acu:= acu + l^.final.nota;
				RecoLis(l^.sig,cant,acu);
				end;
		end;
	var
		cant,acu:integer;
	begin
		cant:= 0;
		acu:= 0;
		RecoLis(l,cant,acu);
		if(cant <> 0)then
		CalcPromedio:= acu/cant
		else
			CalcPromedio:= 0;
	end;

var
	promAct:real;
begin
	if(a <> nil)then begin
		ImpPromedio(a^.HI,prom);
		promAct:= CalcPromedio(a^.datos.Lista);
		if(promAct > prom)then
			writeln('Legajo: ',a^.datos.leg,'. Promedio: ',promAct:0:2);
		ImpPromedio(a^.HD,prom);
			end;
	end; 
		
	
var
	a:arbol;
	prom:real;
begin
	randomize;
	a:= nil;
	GenerarArbol(a);
	//ImpArbol(a);
	writeln('Camtidad de legajos impares: ',legImpar(a));
	ImpFinalesAprobados(a);
	writeln('Ingrese promedio: ');
	readln(prom);
	ImpPromedio(a,prom);
	
end.
