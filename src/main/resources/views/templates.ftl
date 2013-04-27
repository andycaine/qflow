<#macro page title>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    </head>
    <body>
    <div class="container-fluid">
        <h1>${title}</h1>
        <#nested />
    </div>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    </body>
    </html>
</#macro>