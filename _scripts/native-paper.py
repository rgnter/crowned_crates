import os
import sys
import requests
import subprocess

version = '1.17.1'
patch   = '336'
url = "https://papermc.io/api/v2/projects/paper/versions/" + version + "/builds/"+ patch +"/downloads/paper-" + version + "-" + patch +".jar"
filename = "paperclip.jar"

print('Paper version: ' + version + "(" + patch + ")")
if not os.path.isfile('tmp/' + filename):
    print('Download paper...')
    req = requests.get(url, allow_redirects=True)
    print('Download complete!')

    os.mkdir('tmp')
    print('Write file...')
    open('tmp/' + filename, 'wb').write(req.content)
    print('File written!')
else:
    print('Paper already downloaded!')

print('Install paperclip...')
subprocess.run('java -Dpaperclip.install=true -jar tmp/paperclip.jar')
print('Installed paperclip!')