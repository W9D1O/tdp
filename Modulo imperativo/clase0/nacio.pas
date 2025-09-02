program gimnasio;

const
	maxcli = 500;
	maxact = 5;
type
	clientes = 1..maxcli;
	actividades = 1..maxact;
	dias = 1..31;
	meses = 1..12;
	asistencia = record
		dia:dias;
		mes:meses;
		anio:integer;
		num_c:clientes;
		actividad:actividades;
		end;
	arr = array[actividades]of integer;
	
	lis = ^nodo;
	
	nodo = record
		datos:asistencia;
		sig:lis;
		end;

function RandRango():integer;
begin
	RandRango:= random(maxcli + 1);
	end;

procedure LeerDatos(var d:asistencia);
begin
	d.num_c:= RandRango();
	writeln('Ingrese actividad: ');
	readln(d.actividad);
	writeln('Ingrese dia de la asistencia[1..31]: ');
	readln(d.dia);
	writeln('Ingrese mes[1..12]: ');
	readln(d.mes);
	writeln('Ingrese anio: ');
	readln(d.anio);
	end;
	
procedure Ordenado(var l:lis);
var
	datos:asistencia;
	aux,ant,act:lis;
begin
	new(aux);
	ant:= nil;
	act:= nil;
	LeerDatos(datos);
	if(l = nil) or (l^.datos.num_c < datos.num_c)then begin
		aux^.datos:= datos;
		aux^.sig:= l;
		l:= aux;
		end
		else begin
			act:= l;
			while(act <> nil) and (act^.datos.num_c < datos.num_c)do
			begin
				ant:= act;
				act:= act^.sig;
				end;
			if(act <> nil)then begin
				ant^.sig:= aux;
				aux^.sig:= act;
				end
				else begin
					ant^.sig:= aux;
					aux:= nil;
					end;
			end;
			end;

procedure Imp(datos:asistencia);
begin
	writeln(datos.num_c);
	writeln(datos.actividad);
	writeln(datos.dia,' ',datos.mes,' ',datos.anio);
	end;

function IncAsis(asis:integer;cli,num:clientes):integer;
begin
	if(cli = num)then
		asis:= asis + 1;
	IncAsis:= asis;
	end;

function IncAct(num:integer):integer;
begin
	IncAct:= num + 1;
	end;

procedure InitVec(var v:arr);
var
	i:actividades;
begin
	for i:= 1 to maxact do
		v[i]:= 0;
end;

function ActMayor(v:arr):integer;
var
	i,act:actividades;
	max:integer;
begin
	max:= -1;
	for i:= 1 to maxact do
		if v[i] > max then begin
			max:= v[i];
			act:= i;
			end;
	ActMayor:= act;
	end;

procedure Recorre(l:lis;numC:clientes;var canta,actm:integer);
var
	vec:arr;
begin
	InitVec(vec);
	while(l <> nil)do begin
		Imp(l^.datos);
		//Cantidad de asistencias del icliente con el numero "numC"
		canta:= IncAsis(canta,l^.datos.num_c,numC);
		//Aumenta el contador en la posicion recibida
		vec[l^.datos.actividad]:= IncAct(vec[l^.datos.actividad]);
		l:= l^.sig;
		end;
		actm:= ActMayor(vec);
		end;
		
		
//PROGRAMA PRINCIPAL
var
	l:lis;
	numc:clientes;
	asis:integer;
	tact:actividades;
begin		
	l:= nil;
	asis:= 0;
	
end.
