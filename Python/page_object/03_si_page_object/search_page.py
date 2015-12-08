
class SearchPage(object):

    def __init__(self, driver):
        self._driver = driver

    def get_cant_resultados(self):
        return len(self._driver.find_elements_by_css_selector("#searchResults>li"))
