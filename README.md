<h1>Projeto A3 - Análise da Complexidade de Algoritmos</h1>

<h2>Introdução</h2>
<p>O objetivo desta atividade é fornecer uma análise e planos para resolver e desenvolver nosso algoritmo proposto para o Projeto A3, concentrando-se em como os contêineres podem ser distribuídos eficientemente em armazéns e cargas em caminhões.</p>

<h2>1. Identificação da Complexidade do Problema</h2>
<p>Esta questão está associada ao <strong>Problema de Empacotamento</strong>, que é <strong>NP-Completo</strong>.</p>
<ol>
<li>Evitar que os armazéns e caminhões tenham cargas de contêineres alocadas de maneira ineficiente.</li>
<li>Soluções genéricas para o Problema de Empacotamento, um problema clássico NP-Completo, portanto, resumimos que este problema também é <strong>NP-Completo</strong>.</li>
</ol>

<h2>2. Estratégias Sugeridas de Resolução</h2>
<p>Para este problema, a melhor estratégia é a <strong>abordagem gulosa</strong>.</p>
<ol>
<li>Estratégias precisas, como programação dinâmica ou força bruta, estão fora de questão com grandes quantidades de dados devido à alta complexidade.</li>
<li>A abordagem gulosa é eficiente, tentando colocar primeiro os contêineres maiores, para usar o espaço da maneira mais eficiente possível.</li>
<li>Embora não possamos analisar essa abordagem como a melhor solução, ela é fácil de implementar e tem resultados satisfatórios em um período de tempo razoável.</li>
</ol>

<h2>3. Desenvolvimento do Algoritmo</h2>
<p>O algoritmo no qual este artigo se baseia é uma porção do Projeto A3. Ele pode ser implementado em linguagens como <strong>Rust, C, C++, Java ou C#</strong> usando técnicas de ordenação em ordem decrescente de tamanho e, em seguida, alocando em armazéns e caminhões em sequência. Os passos considerados melhores são:</p>
<ul>
<li>Ordenar os contêineres em ordem decrescente.</li>
<li>Para cada contêiner, verificar se ele cabe em algum armazém e alocá-lo se sim.</li>
<li>Distribuir as cargas nos caminhões, tentando economizar espaço sempre que possível.</li>
<li>Na linguagem selecionada e de acordo com requisitos específicos do sistema, os detalhes, é claro, serão diferentes.</li>
</ul>

<h2>4. Análise de Complexidade</h2>

<h3>Ordenação dos Contêineres</h3>
<p>Por exemplo, em Java, o Timsort com uma complexidade no pior caso de <strong>O(n log n)</strong> é usado.</p>

<h3>Alocação em Armazéns de Contêineres</h3>
<p>Iteramos sobre o contêiner (<strong>O(n)</strong>) e, para cada contêiner, verificamos contra os armazéns (<strong>O(m)</strong>, m é o número). Nos piores casos, um armazém verificará todos os contêineres sem encontrar um local uma única vez. <strong>Complexidade:</strong> O(nm)</p>

<h3>Distribuição de Carga nos Caminhões</h3>
<p>Iteramos sobre todos os (carga) contêineres (<strong>O(n)</strong>) e, para eles, pode ser necessário percorrê-los mais de uma vez (<strong>E(k)</strong>, k é o número de caminhões). A complexidade total é, portanto, <strong>O(nk)</strong>.</p>

<h2>Complexidade Final</h2>
<ul>
<li><strong>Ordenação:</strong> O(n log n)</li>
<li><strong>Alocação em Armazéns:</strong> O(n × m)</li>
<li><strong>Alocação em Caminhões:</strong> O(n × k)</li>
</ul>

<h2>Melhor Cenário</h2>
<p>Se M e K forem ambos pequenos e distribuídos uniformemente, então a parte dominante da complexidade será <strong>O(n log n)</strong>.</p>

<h2>Cenário Médio</h2>
<p>Quando M e K mantêm o ritmo com N, a complexidade pode se aproximar de <strong>O(n²)</strong>.</p>

<h2>Pior Cenário</h2>
<p>Em momentos em que o número de armazéns ou caminhões é quase linear em n, pode levar tempo <strong>O(n²)</strong>.</p>