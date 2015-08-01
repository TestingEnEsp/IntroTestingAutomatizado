import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait

# Vemos un ejemplo mas claro de como funciona explicit wait

class SearchTests(unittest.TestCase):
    def setUp(self):
        # Instanciar Firefox
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()

    def test_hello(self):
        # Navegamos hasta la aplicacion
        self.driver.get("http://the-internet.herokuapp.com/dynamic_loading/1")

        # Creamos el WebElement start
        self.start = self.driver.find_element_by_tag_name("button")

        # Hacemos click en Start
        self.start.click()

        finish = WebDriverWait(self.driver, 10)\
            .until(expected_conditions.visibility_of_element_located((By.ID, "finish")))

        # Capturamos todos los elementos que devuelve la busqueda
        self.assertTrue(finish.is_displayed(), "Hello world no fue encontrado!")

    def test_hello2(self):
        # Navegamos hasta la aplicacion
        self.driver.get("http://the-internet.herokuapp.com/dynamic_loading/2")

        # Creamos el WebElement start
        self.start = self.driver.find_element_by_tag_name("button")

        # Hacemos click en Start
        self.start.click()

        finish = WebDriverWait(self.driver, 10)\
            .until(expected_conditions.visibility_of_element_located((By.ID, "finish")))

        # Capturamos todos los elementos que devuelve la busqueda
        self.assertTrue(finish.is_displayed(), "Hello world no fue encontrado!")

    def tearDown(self):
        # Cerramos el navegador
        self.driver.quit()
