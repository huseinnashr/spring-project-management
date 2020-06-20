var chartJsonArray = JSON.parse(decodeHtml(chartData));

var arrayLength = chartJsonArray.length;

var numericData = [];
var labelData = [];

for (var i = 0; i < arrayLength; i++) {
  numericData[i] = chartJsonArray[i].value;
  labelData[i] = chartJsonArray[i].label;
}

new Chart(document.getElementById("myPieChart"), {
  type: "pie",
  data: {
    labels: labelData,
    datasets: [
      {
        label: "Project Statuses",
        backgroundColor: ["#ff2", "#f2f", "#2ff"],
        data: numericData,
      },
    ],
  },
  options: {
    title: {
      display: true,
      text: "Project Statuses",
    },
  },
});

function decodeHtml(html) {
  var txt = document.createElement("textarea");
  txt.innerHTML = html;
  return txt.value;
}
