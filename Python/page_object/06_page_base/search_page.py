from page_base import BasePage


class SearchPage(BasePage):
    def get_cant_resultados(self):
        return len(self._driver.find_elements_by_css_selector("#searchResults>li"))
