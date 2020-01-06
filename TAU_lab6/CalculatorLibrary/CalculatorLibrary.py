from __future__ import with_statement

import os
import subprocess
import sys
import io


class CalculatorLibrary(object):
    def __init__(self, application_path):
        self.application_path = application_path

    def start_app(self):
        os.startfile(self.application_path)
        # s = io.StringIO()
        # sys.stdin = s
        # s.getvalue().encode()
        # print(s)
        # sys.stdin.readline()
        # import subprocess
        # p = subprocess.run(self.application_path, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
        # for line in p.stdout.readlines():
        #     print(line)
        # retval = p.wait()


if __name__ == '__main__':
    app = "D:\\informa\\Semestr 7\\TestowanieAutomtyczne\\cw\\TAU\\TAU_lab6\\" \
          "CalculatorLibrary\\src\\Tau6\\TAULab6\\bin\\Debug\\netcoreapp3.0\\TAULab6.exe"
    CalculatorLibrary(app).start_app()
