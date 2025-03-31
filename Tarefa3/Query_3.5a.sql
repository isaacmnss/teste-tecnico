SELECT dc.Registro_ANS, oa.Razao_Social, SUM(dc.Valor) AS Total_Despesas
FROM demonstracoes_contabeis dc
JOIN operadoras_ativas oa ON dc.Registro_ANS = oa.Registro_ANS
WHERE dc.Evento = 'EVENTOS/SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA À SAÚDE MÉDICO HOSPITALAR'
AND dc.Competencia BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 MONTH) AND CURDATE()
GROUP BY dc.Registro_ANS, oa.Razao_Social
ORDER BY Total
::contentReference[oaicite:45]{index=45}