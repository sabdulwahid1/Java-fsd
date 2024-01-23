<h1>Javascript – Function<h1 />

    <script>

        var x = (2 * 3) + 5;
        var y = 3 * 4;

        var result = myFunction(2, 3);

        document.write("<br />" + result);

        function myFunction(num1, num2) {
                    var a = num1 * num2;
        var b = num1 + num2;
        return (a + b);
                }

        document.write("<br />" + myFunction(3, 4));

        function toCelcius(f) {
                    return (5 / 9) * (f - 32);
                }

        document.write("<br />The temperature is " + toCelcius(60));

    </script>