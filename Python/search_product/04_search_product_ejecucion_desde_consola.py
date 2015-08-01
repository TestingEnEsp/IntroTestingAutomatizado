import unittest
from selenium import webdriver

# En este caso le agregamos al pie del test la configuracion de unittest
# para correr las pruebas desde la consola y ver distintos niveles 
# de informacion sobre el test

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


if __name__ == '__main__':
    unittest.main(verbosity=2)

# verbosity es el nivel de loggin que buscamos obtener
# de unittest cuando corremos el test desde consola
