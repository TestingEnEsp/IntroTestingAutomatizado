from selenium import webdriver


driver = webdriver.Firefox()
driver.maximize_window()

# Navegamos hacia la aplicacion
driver.get("http://www.mercadolibre.com.ar/")

# Creamos el WebElement Search Field
search_field = driver.find_element_by_id("query")

# Introducimos la busqueda
search_field.send_keys("telefonos")

# Realizamos la busqueda
search_field.submit()  # sin presionar el boton buscar
# presionando buscar seria asi
# driver.find_element_by_class_name("nav-search-btn.ml-search-btn").click()

# Capturamos todos los elementos que devuelve la busqueda
products = driver.find_elements_by_css_selector("#searchResults>li")

# Validamos la cantidad de resultados devueltos
assert 50 == len(products), "50 != {0}".format(len(products))
