// Base url
const baseUrl = 'http://localhost:8080';

// Informações obtidas na API
let personsData = [];

// Dados padrao para exemplo
const defaultData = [
  {
    ID: "1",
    Nome: "Luiz Roberto",
    Idade: 33,
    Documentos: [
      {
        Tipo: "CNH",
        Numero: "48848830020",
        Descricao: "Carteira de Motorista",
      },
      {
        Tipo: "RG",
        Numero: "5004002",
        Descricao: "Carteira de Identidade",
      },
      {
        Tipo: "CTPS",
        Numero: "4567898",
        Descricao: "Carteira de Trabalho",
      },
    ],
  },
  {
    ID: "2",
    Nome: "Raimundo Soares",
    Idade: 51,
    Documentos: [
      {
        Tipo: "CNH",
        Numero: "45963548565789",
        Descricao: "Carteira de Motorista",
      },
      {
        Tipo: "RG",
        Numero: "5200785",
        Descricao: "Carteira de Identidade",
      },
      {
        Tipo: "CTPS",
        Numero: "7891237",
        Descricao: "Carteira de Trabalho",
      },
    ],
  },
  {
    ID: "3",
    Nome: "Ana Tavares",
    Idade: 24,
    Documentos: [
      {
        Tipo: "CNH",
        Numero: "65236525662159",
        Descricao: "Carteira de Motorista",
      },
      {
        Tipo: "CPF",
        Numero: "41254125147",
        Descricao: "Cadastro de Pessoa Física",
      },
    ],
  },
  {
    ID: "4",
    Nome: "Janete Niebues",
    Idade: 28,
    Documentos: [
      {
        Tipo: "CPF",
        Numero: "65236525662",
        Descricao: "Cadastro de Pessoa Física",
      },
      {
        Tipo: "RG",
        Numero: "3300785",
        Descricao: "Carteira de Identidade",
      },
      {
        Tipo: "SUS",
        Numero: "784512",
        Descricao: "Sistema Único de Saúde",
      },
    ],
  },
  {
    ID: "5",
    Nome: "Paulo da Rosa",
    Idade: 74,
    Documentos: [
      {
        Tipo: "RG",
        Numero: "5200785",
        Descricao: "Carteira de Identidade",
      },
      {
        Tipo: "CPF",
        Numero: "45621581254 1",
        Descricao: "Cadastro de Pessoa Física",
      },
    ],
  },
  {
    ID: "6",
    Nome: "Wesley Soares",
    Idade: 60,
    Documentos: [
      {
        Tipo: "CNH",
        Numero: "91035698445963",
        Descricao: "Carteira de Motorista",
      },
      {
        Tipo: "RG",
        Numero: "7415595",
        Descricao: "Carteira de Identidade",
      },
      {
        Tipo: "CPF",
        Numero: "45618452136",
        Descricao: "Cadastro de Pessoa Física",
      },
      {
        Tipo: "SUS",
        Numero: "2200789",
        Descricao: "Sistema Único de Saúde",
      },
    ],
  },
  {
    ID: "7",
    Nome: "Tamires Souza",
    Idade: 12,
    Documentos: [
      {
        Tipo: "RG",
        Numero: "7852123",
        Descricao: "Carteira de Identidade",
      },
    ],
  },
];

// Função para obter Dados da API
async function getRemoteData() {
  try {
    const response = await fetch(`${baseUrl}/pessoas`);
    if (!response.ok){
      throw new Error('Atenção: A resposta não foi ok.');
    }
    retrievedData = await response.json();
    personsData = retrievedData.map(p => ({
      ID: p.id,
      Nome: p.nome,
      Idade: p.idade,
      Documentos: p.documentos.map(doc => ({
        Tipo: doc.tipo,
        Numero: doc.numero,
        Descricao: doc.descricao,
      })) 
    }));

    renderTable(personsData);
  } catch (error) {
    console.error('Erro: Ocorreu uma falha ao obter dados das pessoas e o sistema irá usar informações padrão.');
    console.log('Ocorreu uma falha e os dados padrões foram carregados.');
    personsData = defaultData;
    renderTable(personsData);
  }
}

// Função para renderizar a tabela com dados
function renderTable(dados, mostrarApenasDocumento = null) {
  const tbody = document.getElementById("personsData");
  tbody.innerHTML = "";

  dados.forEach((pessoa) => {
    index = 0;
    pessoa.Documentos.forEach((doc) => {
      // Se houver um filtro de documento e o documento atual não corresponder, pule
      if (mostrarApenasDocumento && doc.Tipo !== mostrarApenasDocumento) {
        return;
      }

      const tr = document.createElement("tr");

      if (index == 0) {
        // Adiciona as células
        tr.innerHTML = `
                              <td>${pessoa.ID}</td>
                              <td>${pessoa.Nome}</td>
                              <td>${pessoa.Idade}</td>
                              <td>${doc.Tipo}</td>
                              <td>${doc.Numero}</td>
                              <td>${doc.Descricao}</td>
                          `;
        index++; 
      } else {
        // Adiciona as células
        tr.innerHTML = `
                              <td>&#12291</td>
                              <td>&#12291</td>
                              <td>&#12291</td>
                              <td>${doc.Tipo}</td>
                              <td>${doc.Numero}</td>
                              <td>${doc.Descricao}</td>
                          `;
      }
      tbody.appendChild(tr);
    });
  });
}

// Função para mostrar todos os dados
function displayAll() {
  renderTable(personsData);
  document.getElementById("infoText").textContent =
    "Mostrando todos os registros";
}

// 1 - Função para filtrar por ID
function filterPersonById(personId) {
  const pessoaFiltrada = personsData.filter(
    (pessoa) => pessoa.ID === personId.toString()
  );
  renderTable(pessoaFiltrada);
  document.getElementById(
    "infoText"
  ).textContent = `Mostrando pessoa com ID ${personId}`;
}

// 2 - Função para filtrar pessoas e ordenar em ordem de idade crescente
function sortPersonsByAge() {
  // Ordena por idade
  const sortedPersons = [...personsData].sort((a, b) => a.Idade - b.Idade);

  // Cria uma nova array apenas com os dados necessários
  const result = sortedPersons.map((pessoa) => {
    const cpf = pessoa.Documentos.find((doc) => doc.Tipo === "CPF");
    return {
      ID: pessoa.ID,
      Nome: pessoa.Nome,
      Idade: pessoa.Idade,
      Documentos: [cpf],
    };
  });

  renderTable(result);
  document.getElementById("infoText").textContent =
    "Pessoas com CPFs em ordem crescente de idade";
}

// 3 - Função para filtrar pessoas mais de 50 anos de idade
function filterPersonsAboveAge(targetAge) {
  const filteredPersons = personsData.filter(
    (pessoa) => pessoa.Idade > parseInt(targetAge)
  );

  renderTable(filteredPersons);
  document.getElementById("infoText").textContent =
    "Pessoas com idade superior a 50 anos";
}

// 4 - Função para filtrar pessoas sem CPF
function filterPersonsWithouthCPF() {
  const personsWithouthCPF = personsData.filter((pessoa) => {
    return !pessoa.Documentos.some((doc) => doc.Tipo === "CPF");
  });
  renderTable(personsWithouthCPF);
  document.getElementById("infoText").textContent =
    "Pessoas que não possuem CPF";
}

// 5 - Função para listar os tipos de documentos
function listDocumentTypes() {
  // Criar Set com tipos de documentos para não listar valores duplicados.
  const tiposDocumentos = new Set();
  personsData.forEach((pessoa) => {
    pessoa.Documentos.forEach((doc) => {
      tiposDocumentos.add(doc.Tipo);
    });
  });

  // Prepare table data - one row per document type
  const tbody = document.getElementById("personsData");
  tbody.innerHTML = "";

  tiposDocumentos.forEach((tipo) => {
    const tr = document.createElement("tr");
    tr.innerHTML = `
                    <td colspan="3"></td>
                    <td>${tipo}</td>
                    <td colspan="2"></td>
                `;
    tbody.appendChild(tr);
  });

  document.getElementById("infoText").textContent = "Tipos de documentos";
}

// Carregar os dados da tabela quando a página for carregada
window.onload = getRemoteData;