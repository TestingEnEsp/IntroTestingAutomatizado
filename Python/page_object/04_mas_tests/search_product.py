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
        home_page = HomePage(self.driver)
        results_page = home_page.search_for("phones")

        self.assertEqual(2, results_page.get_cant_resultados())

    def test_search_by_product(self):
        home_page = HomePage(self.driver)
        results_page = home_page.search_for("Oxford")

        self.assertEqual(3, results_page.get_cant_resultados())

    def test_no_results(self):
        home_page = HomePage(self.driver)
        results_page = home_page.search_for("accesories")

        self.assertEqual(0, results_page.get_cant_resultados())

    def tearDown(self):
        # Cerramos el navegador
        self.driver.quit()


if __name__ == '__main__':
    unittest.main(verbosity=2)
