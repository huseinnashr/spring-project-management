new Chart(document.getElementById("myPieChart"), {
  type: "pie",
  data: {
    labels: ["January", "February", "March"],
    datasets: [
      {
        label: "My First dataset",
        backgroundColor: ["#ff2", "#f2f", "#2ff"],
        borderColor: "rgb(255, 99, 132)",
        data: [4, 10, 5],
      },
    ],
  },

  // Configuration options go here
  options: {},
});
