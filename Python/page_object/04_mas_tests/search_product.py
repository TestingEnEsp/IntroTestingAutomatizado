import unittest
from selenium import webdriver
from home_page import HomePage

class SearchTests(unittest.TestCase):
    def setUp(self):
        # Instanciar Firefox
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()

        # Navegamos hasta la aplicacion
        self.driver.get("http://demo.magentocommerce.com/")

    def test_search_by_category(self):
        # Instanciamos la Home Page
        home_page = HomePage(self.driver)
        # Hacemos la busqueda desde la Home Page. Esta busqueda nos devuelve una Results Page
        results_page = home_page.search_for("telefonos")
        
        # Verificamos la cantidad de resultados
        self.assertEqual(50, results_page.get_cant_resultados())
        
    def test_search_by_name(self):
        # Instanciamos la Home Page
        home_page = HomePage(self.driver)
        # Hacemos la busqueda desde la Home Page. Esta busqueda nos devuelve una Results Page
        results_page = home_page.search_for("software testing: fundamental principles and essential know")
        
        # Verificamos la cantidad de resultados
        self.assertEqual(1, results_page.get_cant_resultados())

    def tearDown(self):
        # Cerramos el navegador
        self.driver.quit()


if __name__ == '__main__':
    unittest.main(verbosity=2)
