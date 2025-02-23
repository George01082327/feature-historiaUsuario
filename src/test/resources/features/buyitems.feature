#author: Jorge Ivan Gomez Restrepo
#language: es

Característica: Seleccionar artículos y completar una compra

  Como cliente de SwagLabs
  Necesito seleccionar artículos y completar una compra
  Para poder realizar una compra satisfactoria

  Antecedentes:
    Dado "jorge" abre el sitio web

  @successful
  Esquema del escenario: Seleccionar artículos y terminar una compra
    Y Jorge ingresa las credenciales validas y oprime el boton login
      | user          | pass         |
      | standard_user | secret_sauce |
    Cuando Jorge selecciona varios artículos y los añade al carrito
    Y va al carrito de compra a proceder al checkout con <firstName> <lastName> <zip>
    Entonces validar productos y finalizar compra
    Ejemplos:
      | firstName | lastName | zip    |
      | Jorge     | Gomez    | 005321 |