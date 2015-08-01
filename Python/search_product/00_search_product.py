from selenium import webdriver


driver = webdriver.Firefox()
driver.maximize_window()

# Navegamos hacia la aplicacion
driver.get("http://demo.magentocommerce.com/")

# Creamos el WebElement Search Field
search_field = driver.find_element_by_id("search")

# Introducimos la busqueda
search_field.send_keys("phones")

# Realizamos la busqueda
search_field.submit()  # sin presionar el boton buscar
# presionando buscar
# driver.find_element_by_class_name("search-button").click()

# Capturamos todos los elementos que devuelve la busqueda
products = driver.find_elements_by_css_selector(".product-name a")

assert 3 == len(products)
