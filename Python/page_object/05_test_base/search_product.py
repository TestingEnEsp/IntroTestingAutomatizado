import unittest
from test_base import BaseTestCase
from home_page import HomePage


class SearchTests(BaseTestCase):
    def test_search_by_category(self):
        home_page = HomePage(self.driver)
        results_page = home_page.search_for("telefonos")

        self.assertEqual(50, results_page.get_cant_resultados())

    def test_search_by_name(self):
        home_page = HomePage(self.driver)
        results_page = home_page.search_for("software testing: fundamental principles and essential know")

        self.assertEqual(1, results_page.get_cant_resultados())

    def tearDown(self):
        # Cerramos el navegador
        self.driver.quit()

if __name__ == '__main__':
    unittest.main(verbosity=3)
