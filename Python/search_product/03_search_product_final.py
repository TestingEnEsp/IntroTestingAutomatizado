import unittest
from selenium import webdriver

# En este caso terminamos de armar el test con el teardown 
# para cerrar la prueba

class SearchTests(unittest.TestCase):
    def setUp(self):
        # Instanciar Firefox
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()

        # Navegamos hasta la aplicacion
        self.driver.get("http://demo.magentocommerce.com/")

    def test_search_by_category(self):
        # Creamos el WebElement Search Field
        self.search_field = self.driver.find_element_by_id("search")
        # Introducimos la busqueda
        self.search_field.send_keys("phones")
        self.search_field.submit()
        # self.driver.find_element_by_class_name("search-button").click()

        # Capturamos todos los elementos que devuelve la busqueda
        products = self.driver.find_elements_by_css_selector(".product-name a")
        self.assertEqual(2, len(products))

    def tearDown(self):
        # Cerramos el navegador
        self.driver.quit()
