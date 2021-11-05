# movementsTc
- Primero se debe ejecutar el servidor Eureka que se encuentra en el repositorio https://github.com/ajulcala/eurekaTc
- Segundo se debe ejecutar el servidor Config Server que se encuentra en el repositorio https://github.com/ajulcala/configServerTc
- Tercero registrar CUSTOMER https://github.com/ajulcala/customerTc

MOVEMENTS PERSONAL setcurrentpersonal

Para agregar un movimiento a un SAVING ACCOUNT
http://localhost:8093/api/personal/setsavings a traves de un POST

Estructura
{    
    "condition": 1,
    "amount": 100.00,
    "card": {
        "number": "125-635-888-1",
        "password": "1234"
    }
}

nota: "condition": 1,  //1-deposito 0-retiro

si la Card no exite retornara un mono vacio

Para agregar un movimiento a un CURRENT PERSONAL ACCOUNT
http://localhost:8093/api/personal/setcurrentpersonal a traves de un POST

{    
    "condition": 1,
    "amount": 100.00,
    "card": {
        "number": "125-635-888-1",
        "password": "1234"
    }
}

Para agregar un movimiento a un FIXED TERM ACCOUNT
http://localhost:8093/api/personal/setfixed a traves de un POST

{    
    "condition": 1,
    "amount": 100.00,
    "card": {
        "number": "125-635-888-1",
        "password": "1234"
    }
}

PARA BUSCAR MOVIMIENTOS DE UNA TARJETA:

http://localhost:8093/api/personal/movements a traves de un POST

enviamos la siguiente estructura:
{
   "number": "125-635-888-1",
   "password": "1234"
}

PARA REVIASAR EL SALDO DE UNA CUENTA:

http://localhost:8093/api/personal/checkbalance/savings
http://localhost:8093/api/personal/checkbalance/fixed
http://localhost:8093/api/personal/checkbalance/currentpersonal

enviamos la siguiente estructura:
{
   "number": "125-635-888-1",
   "password": "1234"
}

