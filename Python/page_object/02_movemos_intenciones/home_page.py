from search_page import SearchPage

class HomePage(object):

    def __init__(self, driver):
        self._driver = driver
        self._url = 'http://demo.magentocommerce.com/'
        self._title = 'Madison Island'

    def search_for(self, keyword):
        search_field = self._driver.find_element_by_id("search")
        search_field.send_keys(keyword)
        search_field.submit()

        return SearchPage(self._driver)