<h1>Projeto A3 - Análise da Complexidade de Algoritmos</h1>

<h2>Introdução</h2>
<p>O objetivo desta atividade é fornecer uma análise e planos para resolver e desenvolver nosso algoritmo proposto para o Projeto A3 de Estrutura de Dados e Análise de Algoritmos, concentrando-se em como os contêineres podem ser distribuídos eficientemente em armazéns e cargas em caminhões.</p>

<h2>1. Identificação da Complexidade do Problema</h2>
<p>Esta questão que estamos abordando nesse projeto é muito semelhante ao <strong>Problema de Empacotamento</strong>, que é <strong>NP-Completo</strong>.</p>
<ol>
<li>Evitar que os armazéns e caminhões tenham cargas de contêineres alocadas de maneira ineficiente.</li>
<li>Soluções genéricas para o Problema de Empacotamento, um problema clássico NP-Completo, portanto, também podemos classificar esse problema como <strong>NP-Completo</strong>.</li>
</ol>

<h2>2. Estratégias Sugeridas de Resolução</h2>
<p>Indetificamos que a melhor estratégia para resolver o problema é a <strong>abordagem gulosa</strong> por alguns motivos, como:</p>
<ol>
<li>Programação dinâmica ou força bruta, não são boas opções para grandes quantidades de dados por conta da alta complexidade.</li>
<li>A abordagem gulosa é eficiente, pois, tenta adicionar primeiro os maiores contêineres, assim utiliza o espaço de forma mais eficiente.</li>
<li>É uma abordagem é fácil de implementar e tem resultados que correspondem ao solicitado.</li>
</ol>

<h2>3. Desenvolvimento do Algoritmo</h2>
<p>O algoritmo foi desenvolvido na linguagem Java, usando técnicas de ordenação em ordem crescente de tamanho e realizando a alocação e,m armazéns e caminhões em sequencia. Os os passos que foram considerados os melhores para a composição do algoritmo foram:</p>
<ul>
<li>Ordenar os contêineres em ordem decrescente.</li>
<li>Para cada contêiner, verificar se ele cabe em algum armazém,se sim, realizar a alocação.</li>
<li>Distribuir as cargas nos caminhões tentando economizar espaço sempre que possível.</li>
</ul>

<h2>4. Análise de Complexidade</h2>

<h3>Ordenação dos Contêineres</h3>
<p> Realizado nessa parte do código <strong>containers.sort(Collections.reverseOrder())</strong>.
<p>O <strong>Collections.sort()</strong> em Java utiliza o Timsort que tem a complexidade no pior caso de <strong>O(n log n)</strong>.</p>
<p>Então para conseguir alocar os containers em order decrescente antes de alocar nos armazens é preciso:</p>
<ul>
<li>Definimos o número de container como <strong>n</strong>.
<li>Cada passo da ordenação vai realizar a comparação e a troca, pensando nisso o pior caso do total de comparações e troca vai ser <strong>n log n</strong>.
</ul>
<p> Sendo assim, esse trecho tem complexidade <strong>O(n log n)</strong>.</p>

<h3>Alocação em Armazéns de Contêineres</h3>
<p> Realizado nessa parte do código:</p>
<p>for (int volume : containers) {</p>
<p>    for (Armazem armazem : armazens) {</p>
<p>        if (armazem.adicionarContainer(volume)) {</p>
<p>            break;</p>
<p>        }</p>
<p>    }</p>
<p>}</p>

<p>O objetivo é que para cada contêiner, tenta encontrar um armazém que ainda não esteja cheio, caso não encontre, cria um novo, então:</p>
<ul>
<li>Passa por todos os <strong>n</strong> containêres.</li>
<li>Para cada containêr, percorre todos on <strong>m</strong> armazéns que existem até encontrar um que suporte o volume do containêr. No pior caso não vai caber em nenhum e por isso vai precisar criar um novo</li>
</ul>
<p>O número de armazéns pode subir de forma proporcional a de containêres, então a complexidade é de <strong>O(n x m).</strong>

<h3>Distribuição de Carga nos Caminhões</h3>
<p>Referente a essa parte do código:</p>
<pre><code>
while (!cargasRestantes.isEmpty()) {
    for (i = 0; i < cargasRestantes.size();) {
        if (carga <= restante) {
            remover
        } else {
            fracionar
            break;
        }
    }
}
</code></pre>
<p>Pega a carga de cada caminhão e realiza a alocação em caminhôes até o limite, caso ultrapasse realiza o fracionamento e continua o processo</p>
<ul>
<li>O número de armazéns é m</li>
<li>A lista <strong>cargasRestantes</strong> é modificada dentro do loop, no pior caso pode ser necessário fracionar varias vezes, o que exige mais iterações para consumir a carga, gerando uma complexidade alinhada: loop externo -> até esvaziar a lista(número de caminhões k); loop interno -> percorre as m cargas.</li>
</ul>
<p>Assim no pior caso a complexidade é <strong>O(n x m)</strong></p>

<h2>Complexidade Final</h2>
<ul>
<li><strong>Ordenação:</strong> O(n log n)</li>
<li><strong>Alocação em Armazéns:</strong> O(n × m)</li>
<li><strong>Alocação em Caminhões:</strong> O(n × k)</li>
</ul>

<h2>Melhor Cenário</h2>
<p>Se <strong>m</strong> e <strong>k</strong> forem pequenos e distribuídos de forma uniforme,a parte dominante da complexidade será <strong>O(n log n)</strong>.</p>

<h2>Cenário Médio</h2>
<p>Quando <strong>m</strong> e <strong>k</strong> mantêm o ritmo com <strong>n</strong>, a complexidade pode ser proxima de <strong>O(n²)</strong>.</p>

<h2>Pior Cenário</h2>
<p>Quando o número de armazéns ou caminhões é quase linear em <strong>n</strong>, pode levar tempo <strong>O(n²)</strong>.</p>