import requests

def download_images(base_url, start, end, file_extension="webp", directory="downloaded_images"):
    """
    从给定的基础URL下载特定范围内的图片，并以指定的文件扩展名保存在指定目录下。
    使用模拟的浏览器用户代理(User-Agent)进行下载。

    参数:
    - base_url: 图片基础URL，不包括编号和扩展名，如 "https://example.com/images/"
    - start: 图片编号开始范围
    - end: 图片编号结束范围
    - file_extension: 图片文件扩展名，默认为"webp"
    - directory: 图片将要保存的目录，默认为"downloaded_images"
    """
    import os

    # 确保保存图片的目录存在
    if not os.path.exists(directory):
        os.makedirs(directory)

    # 模拟浏览器的用户代理字符串
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36'
    }

    for i in range(start, end + 1):
        img_url = f"{base_url}{i}.{file_extension}"
        img_response = requests.get(img_url, headers=headers)

        if img_response.status_code == 200:
            with open(f"{directory}/{i}.{file_extension}", "wb") as img_file:
                img_file.write(img_response.content)
            print(f"Image {i}.{file_extension} downloaded.")
        else:
            print(f"Failed to download {img_url}")

# https://book.yunzhan365.com/cdgw/wibl/files/large/80.webp

# 假定基础URL如下所示，不包含编号和扩展名
base_url = "https://book.yunzhan365.com/cdgw/wibl/files/large/"
start = 1
end = 80

# 调用函数
download_images(base_url, start, end)
