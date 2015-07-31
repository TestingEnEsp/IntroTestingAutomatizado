from selenium import webdriver

class SearchTests(object):

        driver = webdriver.Firefox()
        # Navegamos hacia la aplicacion
        driver.get("http://demo.magentocommerce.com/")

        # Creamos el WebElement Search Field
        search_field = driver.find_element_by_id("search")

        # Introducimos la busqueda
        search_field.send_keys("phones")
        search_field.submit()
        # self.driver.find_element_by_class_name("search-button").click()

        # Capturamos todos los elementos que devuelve la busqueda
        products = driver.find_elements_by_css_selector(".product-name a")
        assert 2 == len(products)
