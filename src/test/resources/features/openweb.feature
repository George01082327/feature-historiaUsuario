#author: Jorge Ivan Gomez Restrepo
#language: es

Característica: Abrir una pagina web

  Como cliente de SwagLabs
  Necesito explorar la página y los artículos
  Para poder realizar una compra

  Antecedentes:
    Dado "jorge" abre el sitio web

  @successful
  Esquema del escenario: inicio de sesión exitoso con credenciales válidas
    Y Jorge ingresa las credenciales validas y oprime el boton login
      | user          | pass         |
      | standard_user | secret_sauce |
    Entonces debería ver la página de <text>

    Ejemplos:
      | text     |
      | Products |