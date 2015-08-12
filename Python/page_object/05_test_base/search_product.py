import unittest
from home_page import HomePage
from test_base import BaseTestCase

class SearchTests(BaseTestCase):
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

if __name__ == '__main__':
    unittest.main(verbosity=3)
