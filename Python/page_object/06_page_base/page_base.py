from abc import abstractmethod


class BasePage(object):

    def __init__(self, driver):
        self._driver = driver
        self._url = 'http://demo.magentocommerce.com/'
