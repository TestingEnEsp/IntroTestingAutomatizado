import unittest
from selenium import webdriver
from home_page import HomePage


class SearchTests(unittest.TestCase):
    def setUp(self):
        # Instanciar Firefox
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()

        # Navegamos hasta la aplicacion
        self.driver.get("http://www.mercadolibre.com.ar/")

    def test_search_by_category(self):
        # Instanciamos la Home Page
        home_page = HomePage(self.driver)
        # Hacemos la busqueda desde la Home Page. Esta busqueda nos devuelve una Results Page
        results_page = home_page.search_for("telefonos")
        
        # Verificamos la cantidad de resultados
        self.assertEqual(50, results_page.get_cant_resultados())

    def tearDown(self):
        # Cerramos el navegador
        self.driver.quit()
