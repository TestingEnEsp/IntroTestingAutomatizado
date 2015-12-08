import os
import unittest
from selenium import webdriver

# Vemos como configurar el test para correr otros browsers en forma local

class SearchTests(unittest.TestCase):
    def setUp(self):
        dir = os.getcwd()
        chrome_driver_path = dir + "/chromedriver.exe"
        # El chromedriver.exe debe estar en la misma carpeta que el test
        # Instanciamos Chrome
        self.driver = webdriver.Chrome(chrome_driver_path)
        
        # ejemplo para IE
        # ie_driver_path = dir + "/IEDriverServer.exe"
        # self.driver = webdriver.Ie(chrome_driver_path)

        self.driver.maximize_window()

        # definimos el tiempo de espera por default
        self.driver.implicitly_wait(30)

        # Navegamos hasta la aplicacion
        self.driver.get("http://www.mercadolibre.com.ar/")

    def test_search_by_category(self):
        # Creamos el WebElement Search Field
        search_field = self.driver.find_element_by_id("query")
        # Introducimos la busqueda
        search_field.send_keys("telefonos")
        search_field.submit()
        # self.driver.find_element_by_class_name("nav-search-btn.ml-search-btn").click()

        # Capturamos todos los elementos que devuelve la busqueda
        products = self.driver.find_elements_by_css_selector("#searchResults>li")
        self.assertEqual(50, len(products))

    def test_search_by_name(self):
        # capturamos el search
        search_field = self.driver.find_element_by_id("query")
        search_field.clear()

        # Introducimos la busqueda
        search_field.send_keys("software testing: fundamental principles and essential know")
        search_field.submit()
        # self.driver.find_element_by_class_name("nav-search-btn.ml-search-btn").click()

        # Capturamos todos los elementos que devuelve la busqueda
        products = self.driver.find_elements_by_css_selector("#searchResults>li")
        self.assertEqual(1, len(products))

    def tearDown(self):
        # Cerramos el navegador
        self.driver.quit()
