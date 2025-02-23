#author: Jorge Ivan Gomez Restrepo
#language: es

Característica: Validar Precio y Descripción de un Objeto

  Como cliente de SwagLabs
  Necesito verificar el precio y la descripción de los artículos
  Para asegurarme de que la información es correcta

  Antecedentes:
    Dado "jorge" abre el sitio web

  @successful
  Esquema del escenario: validar precio y descripción de un objeto
    Y Jorge ingresa las credenciales validas y oprime el boton login
      | user         | pass         |
      | problem_user | secret_sauce |
    Cuando selecciona un artículo y ve su página de detalles
    Entonces debería ver el precio del artículo como <precio>
    Y debería ver la descripción del artículo como <descripcion>

    Ejemplos:
      | precio | descripcion                                                                                                                                                            |
      | $49.99 | It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office. |