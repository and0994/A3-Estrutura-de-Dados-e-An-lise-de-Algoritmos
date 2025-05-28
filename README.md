<h1>Analise de Complexidade do algoritmo Big-O</h1>

<h2>Ordenação dos containers</h2> 
<h3>containers.sort(Collections.reverseOrder());</h3> 
O Java usa Timsort para ordenação, que tem uma complexidade de O(n log n) no pior caso.<br><br>
<h2>Alocação dos containers nos armazéns</h2>
<h3>for (int volume : containers) { for (Armazem armazem : armazens) { if (armazem.adicionarContainer(volume)) { break; } } } </h3>
Iteramos sobre os containers (O(n)) e para cada um verificamos os armazéns (O(m), onde m é o número de armazéns).
No pior caso, todos os armazéns são verificados antes de encontrar espaço.
Complexidade: O(n × m)
<h2>Distribuição das cargas nos caminhões</h2> 
<h3>while (!cargasRestantes.isEmpty()) { for (int i = 0; i < cargasRestantes.size();) </h3><br>
Iteramos sobre todas as cargas (O(n)) e pode ser necessário percorrê-las várias vezes (O(k), onde k é o número de caminhões). Assim, a complexidade total é O(n × k).

<h1>Complexidade final</h1>
<h2>Ordenação:</h2> <h3>O(n log n)</h3>
<h2>Alocação nos armazéns:</h2><h3>O(n × m)</h3>
<h2>Alocação nos caminhões:</h2> <h3>O(n × k)</h3>
<h2>Melhor cenário (Best Case)</h2>
Se M e K forem pequenos e bem distribuídos, a complexidade dominante será O(n log n).
<h2>Caso médio (Average Case)</h2>
Se M e K crescerem proporcionalmente a N, a complexidade pode se aproximar de O(n²).
<h2>Pior caso (Worst Case)</h2>
Se o número de armazéns e caminhões cresce quase linearmente com n, o tempo pode ser O(n²).

