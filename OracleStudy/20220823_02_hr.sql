SELECT USER
FROM DUAL;
--HR

--��������ȭ(Nomalization) ����--   SELECT�� �Ľ̼����������� ���� �߿��� �κ�

--������ȭ?
-- �Ѹ���� ������ ���̽� ������ �޸� ���� ��������
-- � �ϳ��� ���̺���... �ĺ��ڸ� ������ �������� ���̺�� ������ ���� ������ ������ �ǹ��Ѵ�. -- �ڹٿ� ���� ���� ���� Ŭ������ �� �޸𸮸� �����°� ó��
                                                               -- -> ����Ŭ�� ����ϴ�.
                                                               
SELECT *               
FROM EMPLOYEES;;

--���̺��� �����ٴ°� �÷��� �������� �����ٴ� �� 
-- �ٸ� �� ������ ���� �ƴ϶� �ĺ��ڸ� ������ �������� ���̺�� �����ٴ� ��

--ex) �����̰�...�������� �Ǹ��Ѵ�.
--    ������Ʈ -> �ŷ�ó ���� ����� �����ִ� ��ø�� ������
--                  �����ͺ��̽�ȭ �Ϸ��� �Ѵ�.

--���̺�� : �ŷ�ó����

/*
10Byte          10Byte  10Byte      10Byte     10Byte 10Byte 10Byte
---------------------------------------------------------------------------
�ŷ�óȸ���   ȸ���ּ�  ȸ����ȭ �ŷ�ó������  ���� �̸���  �޴���
---------------------------------------------------------------------------
    LG       ���￩�ǵ� 02-345-6789 ���̰�     ���� jmk@na.. 010-1...
    LG       ���￩�ǵ� 02-345-6789 ������     ���� jyj@da.. 010-7...
    LG       ���￩�ǵ� 02-345-6789 ������     �븮 cyk@na.. 010-3...
    LG       ���￩�ǵ� 02-345-6789 ����     ���� kys@na.. 010-1...
    SK       ����Ұ��� 02-987-6543 �ֳ���     ���� cny@na.. 010-9...
    LG       �λ굿���� 051-221-2211 ������    �븮 mcw@go.. 010-1....
    LG       ���￩�ǵ� 02-987-6543 ������     ���� ydh@na.. 010-8...    


����) ���� ���ǵ� LG(����) ��� ȸ�翡 �ٹ��ϴ� �ŷ�ó ���� �����
     �� 100�����̶�� �����Ѵ�.
     (�� ��(���ڵ�)�� 70Byte)
     
     �����... ���￩�ǵ� �� ��ġ�� LG���簡 ��� �д����� ����� �����ϰ� �Ǿ���.
     ȸ���ּҴ� ���д����� �ٲ��, ȸ����ȭ�� 031-111-2222 �� �ٲ�ԵǾ���.
     
     �׷��� 100�� ���� ȸ���ּҿ� ȸ����ȭ�� �����ؾ� �Ѵ�.
     
     --�� �� ����Ǿ�� �� ������ -> UPDATE
     
     UPDATE �ŷ�ó����
     SET ȸ���ּ� = '���д�',ȸ����ȭ = '031-111-2222'
     WHERE �ŷ�óȸ��� = 'LG' 
        AND ȸ���ּ� = '���￩�ǵ�';
    
    --100�� �� ���� �ϵ��ũ�󿡼� �о�ٰ�
      �޸𸮿� �ε���� �־�� �Ѵ�.
      ��, 100�� * 70Byte �� ���
      �ϵ� ��ũ�󿡼� �о�ٰ� �޸𸮿� �ε���� �־�� �Ѵٴ� ���̴�.
      
        ->�̴� ���̺��� ���谡 �߸��Ǿ����Ƿ�
          DB������ ������ �޸� ���� ���� DOWN�� ���̴�.
            
            ->�׷��Ƿ� ����ȭ ������ �����ؾ� �Ѵ�.
    
    ����ȭ ������ step by step���� 1����ȭ -> 2����ȭ -> 3.... �̷��� �����Ѵ�
    
    
--�� 1����ȭ
--> � �ϳ��� ���̺� �ݺ��Ǵ� �÷� ������ �����Ѵٸ�
-- ������ �ݺ��Ǿ� ������ �÷��� �и��Ͽ�
--���ο� ���̺��� ������ش�.


���̺�� : ȸ�� ->�θ� ���̺�

10Byte  10Byte          10Byte  10Byte   
-----------------------------------
ȸ��ID �ŷ�óȸ���   ȸ���ּ�  ȸ����ȭ
-----
�ڽ��� �����ϴ� �÷�(�θ� �����޴� �÷�)
-----------------------------------
10    LG       ���￩�ǵ� 02-345-6789 
20    SK       ����Ұ��� 02-987-6543 
30    LG       �λ굿���� 051-221-2211 

�ŷ�óȸ��� ȸ���ּ� ȸ����ȭ 3�������δ� �������̺�� �����Ҽ� �����Ƿ� �ĺ��ڷ� ȸ�� ID�� �ִ´�.  


--���̺�� : ���� -> �ڽ� ���̺�

 10Byte     10Byte 10Byte 10Byte   10Byte
--------------------------------------------
�ŷ�ó������  ���� �̸���  �޴���  ȸ��ID
                                 -----
                                 �����ϴ� �÷�
----------------------------------------------
���̰�     ���� jmk@na.. 010-1... 10
������     ���� jyj@da.. 010-7... 10
������     �븮 cyk@na.. 010-3... 10
����     ���� kys@na.. 010-1... 10
�ֳ���     ���� cny@na.. 010-9... 20
������    �븮 mcw@go.. 010-1.... 30
������     ���� ydh@na.. 010-8... 20
:
*/

-->�� 1����ȭ�� �����ϴ� �������� �и��� ���̺���
-- �ݵ�� �θ� ���̺�� �ڽ� ���̺��� ���踦 ������ �ȴ�.

-->�θ� ���̺� -> �����޴� �÷� -> PRIMARY KEY
--�ڽ� ���̺� -> �����ϴ� �÷�  -> FOREIGN KEY

--�������޴� �÷��� ���� Ư¡ (PRIMARY KEY)
-- �ݵ�� ������ ��(������)�� ���;� �Ѵ�.
-- �ߺ��� ��(������)�� �־�� �ȵȴ�.
-- ���������(NULL�� �־��) �ȵȴ�.
-- ��, NOT NULL �̾�� �Ѵ�.


-->�� 1 ����ȭ�� �����ϴ� ��������
-- �θ� ���̺��� PRIMARY KEY �� �׻� �ڽ� ���̺��� FOREIGN KEY�� ���̵ȴ�.

--��ü���� �����ͷ��� �þ�� ���ϴ� �ɱ�?
-- ���̺��� �и�(����)�Ǳ� ���� ���·� ��ȸ

SELECT A.�ŷ�óȸ���, A.ȸ���ּ�, A.ȸ����ȭ
       B.�ŷ�ó������, B.����, B.�̸���, B.�޴���
FROM ȸ�� A, ���� B
WHERE A.ȸ��ID = B.ȸ��ID (���� �����͵鳢�� ���´�.)

/*
����) ���� ���ǵ� LG(����) ��� ȸ�翡 �ٹ��ϴ� �ŷ�ó ���� �����
     �� 100�����̶�� �����Ѵ�.
        
     �����... ���￩�ǵ� �� ��ġ�� LG���簡 ��� �д����� ����� �����ϰ� �Ǿ���.
     ȸ���ּҴ� ���д����� �ٲ��, ȸ����ȭ�� 031-111-2222 �� �ٲ�ԵǾ���.
     
     �Ʊ�� �޸� �и��Ǿ����Ƿ�  ȸ�� ���̺��� 1���� ȸ���ּҿ� ȸ�� ��ȭ�� �����ؾ� �Ѵ�.
     
     --�� �� ����Ǿ�� �� ������ -> UPDATE
     
     UPDATE �ŷ�ó����
     SET ȸ���ּ� = '���д�',ȸ����ȭ = '031-111-2222'
     WHERE �ŷ�óȸ��� = 'LG' 
        AND ȸ���ּ� = '���￩�ǵ�';
    
     UPDATE ȸ��
     SET ȸ���ּ� = '���д�',ȸ����ȭ = '031-111-2222'
     WHERE ȸ�� ID = 10; 
    
    --1 �� ���� �ϵ��ũ�󿡼� �о�ٰ�
      �޸𸮿� �ε���� �־�� �Ѵ�.
      ��, 1 * 40Byte ��
      �ϵ� ��ũ�󿡼� �о�ٰ� �޸𸮿� �ε���� �־�� �Ѵٴ� ���̴�.
      
      ->����ȭ �������� 100�� ���� ó���ؾ� �� ��������
        1�Ǹ� ó���ϸ� �Ǵ� ������ �ٲ� ��Ȳ�̱� ������
        DB������ �޸� ���� �Ͼ�� �ʰ� ���� ������ ó���� ���̴�.
        
         --�ŷ�óȸ���, ȸ����ȭ
        SELECT �ŷ�ó ȸ���, ȸ����ȭ        |   SELECT �ŷ�óȸ���, ȸ����ȭ     
        FROM ȸ��;                           |  FROM �ŷ�ó����;
        --> 3*40Byte �� �޸� �Ҹ�           | -->200��*70Byte
 
 
        --�ŷ�ó ������, ����               |  
        SELECT �ŷ�ó������, ����           |  SELECT �ŷ�ó������, ����
        FROM ����;                         |   FROM �ŷ�ó����;
        -->200�� * 50Byte                   |   -->200�� * 70Byte
        
--�ŷ�óȸ���, �ŷ�ó ������

SELECT ȸ��.�ŷ�óȸ���, ����.�ŷ�ó������       |  SELECT �ŷ�óȸ���, �ŷ�ó������
FROM ȸ�� JOIN ����                             |   FROM �ŷ�ó����;
ON ȸ��.ȸ��ID = ����.ȸ��ID;                     |  -->200�� * 70Byte
--> (3*40Byte) + (200��*50Byte)

�� ����ȭ �ϸ� ��� ��쿡�� �޸𸮸� �� �Һ��Ѵ�.

*/




--���̺�� : �ֹ�
/*
----------------------------------------------------------------------------
��ID                ��ǰ�ڵ�           �ֹ�����            �ֹ�����
-----
�̸� PRIMARY KEY�� ������ ��� �ٽô� �� ���̺� ���ü� ����.
                     --------
                     �ٽô� �� ���̺� ���ü� ����.
                                       --------
                                       ���� �ð��뿡 ������ �ֹ��� �� ����
                                                            ------
                                                            �ٽô� 10���� ���Ǵ�.
-----------------------------------------------------------------------------
KIK1174(���α�)        P-KKBK(�ܲʹ��)   2022-04-30 13:50:23   10
KYL8335(������)        P-KKBC(����Ĩ)     2022-04-30 14:23:11   20
MCW3235(������)        P-KKDS(��ũ�ٽ�)   2022-05-11 16:14:37   12
CHH5834(������)        P-SWKK(�����)     2022-05-11 10:32:48   12
                           :
                           :
                           
----------------------------------------------------------------------------
*/

--���ϳ��� ���̺� �����ϴ� PRIMARY KEY�� �ִ� ������ 1���̴�.
--   ������, PRIMARY KEY�� �����ϴ� �÷��� ������ ����(������)�� ���� �����ϴ�.
--  �÷� 1���θ� ������ PRIMARY KEY�� SINGLE PRIMARY KEY��� �θ���.
-- (���� �����̸Ӹ� Ű)
-- �� �� �̻��� �÷����� ������ PRIMARY KEY�� COMPOSITE PRIMARY KEY��� �θ���.
-- (���� �����̸Ӹ� Ű)

-- �� ID + ��ǰ�ڵ� + �ֹ����� �� ��� PRIMARY KEY�� �����ϸ� ��ĥ���� ����.


--�� 2 ����ȭ
-->�� 1����ȭ�� ��ģ ��������� PRIMARY KEY �� SINGLE COLUMN�̶�� 
-- �� 2����ȭ�� �������� �ʴ´�.
-- ������, PRIMARY KEYŰ�� COMPOSITE COLUMN �̶��
-- ��.��.�� �� 2����ȭ�� �����ؾ� �Ѵ�.
-- �������̸� ���������̸Ӹ� Ű�� ���ַ��� �����ϴ� 2����ȭ

-->�ĺ��ڰ� �ƴ� �÷��� �ĺ��� ��ü �÷��� ���� �������̾���ϴµ� 
--�ĺ��� ��ü �÷��� �ƴ� �Ϻ� �ĺ��� �÷��� ���ؼ��� �������̶��  �������̴�= �ĺ��ڰ� �ٲ�� �ٸ� �÷����� ���� �ٲ��.
-- �̸� �и��Ͽ� ���ο� ���̺��� �������ش�.
-- �� ������ �� 2 ����ȭ�� �Ѵ�.

/*
--���̺�� : ���� ->�θ� ���̺�

-------------------------------------------------------------
�����ȣ ����� ������ȣ �����ڸ� ���ǽ��ڵ� ���ǽǼ���
-------         ------   PRIMARY KEY
-------------------------------------------------------------
J0101   �ڹٱ���   21     ������ó A301      ����ǽ��� 3�� 40�� �Ը�
J0102   �ڹ��߱�   22     �׽���   T502       ���ڰ��а� 5�� 60�� �Ը�
03090   ����Ŭ�߱� 22    �׽���    A201      ����ǽ��� 2�� 30�� �Ը�
03010   ����Ŭ��ȭ 10     �念��   T502      ���ڰ��а� 5�� 60�� �Ը�
J3342   JSP����    20    �ƽ���    K101      �ι����а� 1�� 90�� �Ը�
----------------------------------------------------------------

�����ȣ ����� �и� ������� �����ȣ���� ������

������ȣ �����ڸ� �и� �����ڸ��� ������ȣ���� ������


--���̺�� : ����

-------------------------------------
�����ȣ  ������ȣ  �й�          ����
-------  ------- FORIEN KEY

-------            -----  PRIMARY KEY
-------------------------------------
03090      22      2209130(���¹�) 92
03090      22      2209142(������) 80
03090      22      2209151(�ֳ���) 96
                  :
-------------------------------------            
*/


--�� 3 ����ȭ
--> 2����ȭ �� �ĺ��ڰ� �ƴ��÷��� �ĺ��ڰ� �ƴ��÷����� �������� ��Ȳ�̶��
-- �̸� �и��Ͽ� ���ο� ���̺��� ������ �־�� �Ѵ�. (ex ���ǽ��ڵ忡 �������� ���ǽ� ����)
-- �� ������ �� 3 �������̶� �Ѵ�.


--�ذ���(Relation)�� ����
  
-->1 : n�� ����  : 1���� �θ� �������� �ڽ� ������ ȸ��ID 10 = 1��   �ڽ��� ȸ��ID 10�� ������
-- ������ �����ͺ��̽��� Ȱ���ϴ� �������� �߱��ؾ� �ϴ� ����

-- 1 : 1 ����
--> ����, ���������� ������ �� �ִ� �����̱� ������
-- ������ �����ͺ��̽� ���� �������� �������̸� ���ؾ� �� ����.

-- n : n ����
--������ �𵨸������� ������ �� ������
-- ���� �������� �𵨸������� ������ �� ���� ����.

/*
--���̺�� : ��                    - ���̺�� : ��ǰ
-----------------------------------------------------------------------
����ȣ ���� �̸���     ��ȭ��ȣ    ��ǰ��ȣ  ��ǰ��  ��ǰ�ܰ�  ��ǰ����...
+++++++                              ++++++
-----------------------------------  -------------------------------------
1001     ����  abc@tes.. 010-1....   pswk     �����   500     ������ ÷��...
1002     ���α�  bcd@tes.. 010-2....    pkjk    ���ڱ�    600     ���ڶ�� �һ�...
1003     ���¹�  cde@tes.. 010-3...    pkkm     ������  700     ���� ��� �һ�
1004     ������  def@tes.. 010-4...    pjkc     �ڰ�ġ    400     �ڰ��� ����ִ�...
              :                                      :
----------------------------------   -----------------------------------------
                ���� ��ǰ�� �󸶵��� ����ɼ� �ְ� ��ǰ�� ���� �󸶵��� ���Ѿ��� ����ɼ� �ִ�.
                (���ΰ��� ���� ���谡 ���⶧����...)
                
              ++++: n:n���踦 ��Ʈ���� Ű���� ���� �� � ���� � ��ǰ��ȣ�� �� ���� ���踦 �����
              1:n�� ����� ����°� �� �̷��� �ϴ°��� 4����ȭ �̴�.
              
               �̰� n : n�� �����̱⿡  1:n�� ����� ������� �ʿ䰡 �ִ�.

                    -���̺�� : �ֹ�����(�Ǹ�) 
                -------------------------------------------------
                �ֹ���ȣ  ����ȣ  ��ǰ��ȣ  �ֹ�����   �ֹ�����
                -------------------------------------------------
                27        1001      pswk      2022-06-.. 10
                28        1001      pkjk      2022-06-.. 30
                29        1001      pswk      2022-06-.. 20
                30        1002      pswk      2022-06-.. 20
                31        1002      pswk      2022-07-.. 50
               
*/



-- �� 4����ȭ
--> ������ Ȯ���� ����� ���� n:n ���踦
-- 1:n ����� ���߸��� ������ �ٷ� �� 4����ȭ ���� �����̴�.
-- �� �������� �Ļ� ���̺��� �����ϰ� �ǰ� �� ���̺��� n : n���踦 1:n����� ���߸��� ������ �����Ѵ�.
/*
1����ȭ  �ߺ��Ǵ� ���� �ִٸ� �ߺ��Ǵ� ���鳢�� ���� ���̺��� �����Ѵ�. �� ���̺������ �ٸ� �����͵���� �ĺ��ڸ� �����Ѵ�.

2����ȭ �ĺ��ڰ� �ƴ��÷��� �ĺ��ڿ��� �������̾���ϴµ� ���� �����̸Ӹ�Ű��� �� �ĺ��� �÷��� �����ϴ� �͵鳢�� ���� ���̺���� 
       �� ���������� ���� �����̸Ӹ� Ű�� ������ ���� �ִ�.
       
3����ȭ  �ĺ��ڰ� �ƴ� �÷��鳢���� ����� ���ǽ� �ڵ� : ���ǽ� ����� ���� �ĺ��ڰ� �ƴѰ͵鳢�� �������谡 ������� �׵鳢�� ���� ���̺����

4����ȭ �л�  ���� ������ '������û'�̶���� '��'�� '��ǰ'������ '�ֹ�����'����� �� ���̺��� n:n���踦 1:n����� ����� ����
      ���̺��� �����ϴ°��� �� 4 ����ȭ �����̴�.
      
      */
      


--������ȭ (������ȭ)
--���� �ľ��� ������ �ߵǾ��־�� ������ �� �ִ�.

--A�� ��� (Case 1)

--���̺�� : �μ�               --���̺�� : ���
-- 10       10     10           10       10      10    10   10       10
------------------------      --------------------------------------------
--�μ���ȣ  �μ���   �ּ�       �����ȣ  �����  ����   �޿�  �Ի���  �μ���ȣ
------------------------      --------------------------------------------
--  10���� ��(���ڵ�)                     1,000,000�� ��(���ڵ�)
------------------------      --------------------------------------------

-->��ȸ �����
--------------------------
--�μ���  �����  ���� �޿�
--------------------------

--> �μ� ���̺��   ��� ���̺��� JOIN ���� ���� ũ��
--  10*30Byte +    100��*60Byte  =  300+ 6000��  = 6000�� 300Byte

--��� ���̺��� ������ȭ �� �� �� ���̺� �о�� ���� ũ��
-- �� �μ� ���̺��� �μ��� �÷��� ��� ���̺� �߰��� ���
-- 100�� * 70 Byte = 7õ�� Byte 
--�� �������� �� ũ�Ƿ� ������ȭ�� �������� �ʴ°��� �´�.

--���� �μ� ���̺��� 50�� ���� ���ڵ带 ������ �ִٸ� �� �θ�� �ڽ����̺��� ���ڵ���� ũ�� ���̰� �ȳ��ٸ�
--������ȭ�� �ϴ°��� �� �޸𸮸� ���� �Ҹ��ϹǷ� ������ȭ�� �����ϴ� ���� �´�.
--�ٸ� �̴� ������ ���� ����� ���ؿ� �ľ��� �ʿ��ϴ�.

/*
����ȭ 
������ ���̽� �޸� ���� �������� �ĺ��ڸ� ���� �ϴ� ������� ���̺��� ������ �и��ϴ� ��

����ȭ��
��1����ȭ ��2����ȭ ��3����ȭ ��4����ȭ ������ȭ
������ ��� �Ұ�

��1 ����ȭ�� �ݺ��Ǵ� �͵��� �ĺ��ڸ� �������θ� ���ø��� 
LGLGLG SKSK �� ���� ������ ���ø� ��
�θ�� �ڽ� ���踦 ����
-�����޴� �θ�
-�����ϴ� �ڽ�
�� 1����ȭ�� ��ġ�� ���� 1��� ���� �����ϰ� ��

�θ��� �����̸Ӹ�Ű ���������� ������ ����
�����Ѱ� �� (�ߺ�X),NOT NULL

�����̸Ӹ�Ű �������� �����̺� �ִ� 1��
�����̸Ӹ�Ű�� �����ϴ� �÷��� 1�� - �̱�

�����̸Ӹ�Ű�� �����ϴ� �÷��� �ټ� - ����



�̱��̶�� ��2����ȭ ����X
�����̶�� ��2����ȭ �ݵ�� ����

�� 2����ȭ 
���� ������
����,���� / ����,�¹� ���ø��� 

��3����ȭ
�ĺ��ڰ� �ƴ� �÷��鳢�� �������϶�
���ǽ��ڵ� / ���ǽǼ���


���� + ��4����ȭ ������
*/
--������
/*
1. ����(relation)
  -��� ��Ʈ��(entry)�� ���ϰ��� ������.
  -�� ��(column)�� ������ �̸��� ������ ������ ���ǹ��ϴ�.
  -���̺��� ��� ��(row==Ʃ��=tuple)�� �������� ������ ������ ���ǹ��ϴ�.
  
2.�Ӽ�(attribute)
   - ���̺��� ��(column)�� ��Ÿ����.
   - �ڷ��� �̸��� ���� �ּ� ���� ���� : ��ü�� ����, ���� ���
   - �Ϲ� ����(file)�� �׸�(������=item=�ʵ�=field)�� �ش��Ѵ�.
   -��ƼƼ(entity)�� Ư���� ���¸� ���
   -�Ӽ�(attribute)�� �̸��� ��� �޶�� �Ѵ�.
   
3. Ʃ��(tuple)
   -���̺��� ��(row==��ƼƼ==entity)
   -������ ��� �Ӽ����� ����
   -���� ���� ����
   -�Ϲ� ����(file)�� ���ڵ�(record)�� �ش��Ѵ�.
   -Ʃ�� ����(tuple variable)
    :Ʃ��(tuple)�� ����Ű�� ����, ��� Ʃ�� ������ ���������� �ϴ� ����
    
4. ������(domain)
   - �� �Ӽ�(attribute)�� ���� �� �ֵ��� ���� ������ ����
   - �Ӽ� ��� ������ ���� �ݵ�� ������ �ʿ�� ����.
   - ��� �����̼ǿ��� ��� �Ӽ����� �������� ������(atomic)�̾�� ��.
   - ������ ������
     : �������� ���Ұ� �� �̻� �������� �� ���� ����ü�� ���� ��Ÿ��.
     
5. �����̼�(relation) (����)
   -���� �ý��ۿ��� ���ϰ� ���� ����
   -�ߺ��� Ʃ��(tuple=entity=��ƼƼ)�� �������� �ʴ´�. -> ��� ������(Ʃ���� ���ϼ�)
   -�����̼� = Ʃ��(��ƼƼ=entity)�� ����. ���� Ʃ���� ������ ���ǹ��ϴ�.
   -�Ӽ�(attribute)������ ������ ����.
*/

/*
---���ṫ�Ἲ(Integrity)����---

1.���Ἲ���� ��ü ���Ἲ(Entity Integrity)
            ���� ���Ἲ(Relational Integrity)
            ������ ���Ἲ(Domain Integrity)�� �ִ�.
            

2. ��ü ���Ἲ
   ��ü ���Ἲ�� �����̼ǿ��� ����Ǵ� Ʃ��(tuple)(��)��
   ���ϼ��� �����ϱ� ���� ��������
   
3. ���� ���Ἲ
   ���� ���Ἲ�� �����̼� ���� ������ �ϰ�����
   �����ϱ� ���� ��������. �� �����Ӱ� �����͸� �Է����� ���ϵ��� ���Ƴ�����

4. ������ ���Ἲ
   ������ ���Ἲ�� ��� ������ ���� ������
   �����ϱ� ���� ���������̴�.

5. ���������� ����
   
   -PRIMARY KEY(PK:P) -> �⺻Ű, ����Ű, �ĺ�Ű, �ĺ���
    �ش� �÷��� ���� �ݵ�� �����ؾ� �ϸ�, �����ؾ� �Ѵ�.
    (NOT NULL �� UNIQUE �� ���յ� ����)
    
   -FOREIGN KEY(FK:F:R) �� �ܷ�Ű, �ܺ�Ű, ����Ű
   �ش� �÷��� ���� �����Ǵ� ���̺��� �÷� �����͵� �� �ϳ���
   ��ġ�ϰų� NULL�� ������.
   
   -UNIQUE(UK:U)
    ���̺� ������ �ش� �÷��� ���� �׻� �����ؾ� �Ѵ�.
    
   -NOT NULL(NN:CK:C)
    �ش� �÷��� NULL�� ������ �� ����.
    
   -CHECK(CK:C)
    �ش� �÷��� ���� ������ �������� ������ ������ �����Ѵ�.

*/


---���� PRIMARY KEY ����----

--1. ���̺� ���� �⺻ Ű�� �����Ѵ�.

--2. ���̺��� �� ���� �����ϰ� �ĺ��ϴ� �÷� �Ǵ� �÷��� �����̴�.
--   �⺻Ű�� ���̺� �� �ִ� �ϳ��� �����Ѵ�.
--   �׷��� �ݵ�� �ϳ��� �÷����θ� �����Ǵ� ���� �ƴϴ�.
--   NULL�� �� ����, �̹� ���̺� �����ϰ� �ִ� �����͸�
--  �ٽ� �Է��� �� ������ ó���Ѵ�.(���ϼ�)
--  UNIQUE INDEX �� ����Ŭ ���������� �ڵ����� �����ȴ�.

--3. ���� �� ����
-- ���÷� ������ ����
-- �÷��� ������ Ÿ�� [CONSTRAINT CONSTRAINT��] PRIVARY KEY[(�÷���,...)]

--�� ���̺� ������ ����
-- �÷��� ������Ÿ��,
-- �÷��� ������Ÿ��,
--CONSTRAINT CONSTRAINT��  PRIVARY KEY[(�÷���,...)

--4. CONSTRAINT �߰� �� CONSTRAINT���� �����ϸ�
--   ����Ŭ ������ �ڵ������� CONSTRAINT���� �ο��Ѵ�.
-- �Ϲ������� CONSTRAINT���� ���̺��_�÷���_CONSTRAINT����
-- �������� ����Ѵ�.

--��PK ���� �ǽ�(1. �÷� ������ ����)
--���̺� ����
CREATE TABLE TBL_TEST1
( COL1 NUMBER(5)     PRIMARY KEY
, COL2 VARCHAR2(30)
);


SELECT *
FROM TBL_TEST1;

DESC TBL_TEST1;
/*
COL1 NOT NULL NUMBER(5)   PRIMARY KEY ��� ���������� �־����� NOT NULL ������ �ڵ����� ���Եȴ�. 
COL2          VARCHAR2(30) 
*/

INSERT INTO TBL_TEST1(COL1,COL2) VALUES(1,'TEST');
INSERT INTO TBL_TEST1(COL1,COL2) VALUES(1,'TEST'); 
--ORA-00001: unique constraint (HR.SYS_C007116) violated
--������ ���� ������ �ϴµ� �ߺ��ǹǷ� �ȵ�
INSERT INTO TBL_TEST1(COL1,COL2) VALUES(1,'ABCD');
----ORA-00001: unique constraint (HR.SYS_C007116) violated
INSERT INTO TBL_TEST1(COL1,COL2) VALUES(2,'ABCD');
INSERT INTO TBL_TEST1(COL1,COL2) VALUES(3,NULL);
INSERT INTO TBL_TEST1(COL1) VALUES(4); --�ι�° �÷��� �ڵ����� NULL Ȥ�� DEFAULT�� �ִٸ� ����Ʈ���� ����.
INSERT INTO TBL_TEST1(COL1,COL2) VALUES(5,'ABCD');
INSERT INTO TBL_TEST1(COL1,COL2) VALUES(NULL,NULL); --�ȵ�

COMMIT;
--==>>Ŀ�� �Ϸ�.

SELECT *
FROM TBL_TEST1;
/*
1	TEST
2	ABCD
3	
4	
5	ABCD
*/


DESC TBL_TEST1;
--==>>
/*
�̸�   ��?       ����           
---- -------- ------------ 
COL1 NOT NULL NUMBER(5)   ->PK �������� Ȯ�� �Ұ� 
COL2          VARCHAR2(30) 
*/

--������ ���� Ȯ��
SELECT *
FROM USER_CONSTRAINTS;
/*
HR	REGION_ID_NN	C	REGIONS	"REGION_ID" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	REG_ID_PK	P	REGIONS					ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29	HR	REG_ID_PK		
HR	COUNTRY_ID_NN	C	COUNTRIES	"COUNTRY_ID" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	COUNTRY_C_ID_PK	P	COUNTRIES					ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29	HR	COUNTRY_C_ID_PK		
HR	COUNTR_REG_FK	R	COUNTRIES		HR	REG_ID_PK	NO ACTION	ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	LOC_CITY_NN	C	LOCATIONS	"CITY" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	LOC_ID_PK	P	LOCATIONS					ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29	HR	LOC_ID_PK		
HR	LOC_C_ID_FK	R	LOCATIONS		HR	COUNTRY_C_ID_PK	NO ACTION	ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	DEPT_NAME_NN	C	DEPARTMENTS	"DEPARTMENT_NAME" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	DEPT_ID_PK	P	DEPARTMENTS					ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29	HR	DEPT_ID_PK		
HR	DEPT_LOC_FK	R	DEPARTMENTS		HR	LOC_ID_PK	NO ACTION	ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	JOB_TITLE_NN	C	JOBS	"JOB_TITLE" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	JOB_ID_PK	P	JOBS					ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29	HR	JOB_ID_PK		
HR	EMP_LAST_NAME_NN	C	EMPLOYEES	"LAST_NAME" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	EMP_EMAIL_NN	C	EMPLOYEES	"EMAIL" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	EMP_HIRE_DATE_NN	C	EMPLOYEES	"HIRE_DATE" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	EMP_JOB_NN	C	EMPLOYEES	"JOB_ID" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	EMP_SALARY_MIN	C	EMPLOYEES	salary > 0				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	EMP_EMAIL_UK	U	EMPLOYEES					ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29	HR	EMP_EMAIL_UK		
HR	EMP_EMP_ID_PK	P	EMPLOYEES					ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29	HR	EMP_EMP_ID_PK		
HR	EMP_DEPT_FK	R	EMPLOYEES		HR	DEPT_ID_PK	NO ACTION	ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	EMP_JOB_FK	R	EMPLOYEES		HR	JOB_ID_PK	NO ACTION	ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	EMP_MANAGER_FK	R	EMPLOYEES		HR	EMP_EMP_ID_PK	NO ACTION	ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	DEPT_MGR_FK	R	DEPARTMENTS		HR	EMP_EMP_ID_PK	NO ACTION	ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	JHIST_EMPLOYEE_NN	C	JOB_HISTORY	"EMPLOYEE_ID" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	JHIST_START_DATE_NN	C	JOB_HISTORY	"START_DATE" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	JHIST_END_DATE_NN	C	JOB_HISTORY	"END_DATE" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	JHIST_JOB_NN	C	JOB_HISTORY	"JOB_ID" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	JHIST_DATE_INTERVAL	C	JOB_HISTORY	end_date > start_date				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	JHIST_EMP_ID_ST_DATE_PK	P	JOB_HISTORY					ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29	HR	JHIST_EMP_ID_ST_DATE_PK		
HR	JHIST_JOB_FK	R	JOB_HISTORY		HR	JOB_ID_PK	NO ACTION	ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	JHIST_EMP_FK	R	JOB_HISTORY		HR	EMP_EMP_ID_PK	NO ACTION	ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	JHIST_DEPT_FK	R	JOB_HISTORY		HR	DEPT_ID_PK	NO ACTION	ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	USER NAME			2014-05-29				
HR	SYS_C004102	O	EMP_DETAILS_VIEW					ENABLED	NOT DEFERRABLE	IMMEDIATE	NOT VALIDATED	GENERATED NAME			2014-05-29				
HR	SYS_C007100	C	EJD	"�̸�" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	GENERATED NAME			2022-08-22				
HR	SYS_C007101	C	EJD	"����" IS NOT NULL				ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	GENERATED NAME			2022-08-22				
HR	SYS_C007116	P	TBL_TEST1					ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	GENERATED NAME			2022-08-24	HR	SYS_C007116		
*/

SELECT *
FROM USER_CONSTRAINTS
WHERE TABLE_NAME= 'TBL_TEST1';
--HR	SYS_C007116	P	TBL_TEST1					ENABLED	NOT DEFERRABLE	IMMEDIATE	VALIDATED	GENERATED NAME			2022-08-24	HR	SYS_C007116		


SELECT *
FROM USER_CONS_COLUMNS; --���������� ������ �÷��� Ȯ��

SELECT *
FROM USER_CONS_COLUMNS 
WHERE TABLE_NAME = 'TBL_TEST1';

--��USER_CONSTRAINTS �� USER_CONS_COLUMNS �� ������� 
-- ���������� ������ ������, �������Ǹ�, ���̺��, ������������, �÷��� �׸��� ��ȸ�Ѵ�.

SELECT UC.OWNER "������" , UC.CONSTRAINT_NAME "�������Ǹ�" , UC.TABLE_NAME "���̺��", UC.CONSTRAINT_TYPE "������������"
       ,UCC.COLUMN_NAME "�÷���"
FROM USER_CONS_COLUMNS UCC , USER_CONSTRAINTS UC
 WHERE UCC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME;
 
SELECT UC.OWNER "������" , UC.CONSTRAINT_NAME "�������Ǹ�" , UC.TABLE_NAME "���̺��", UC.CONSTRAINT_TYPE "������������"
       ,UCC.COLUMN_NAME "�÷���"
FROM USER_CONS_COLUMNS UCC , USER_CONSTRAINTS UC
 WHERE UCC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME
 AND UC.TABLE_NAME = 'TBL_TEST1'; 


SELECT UC.OWNER "������" , UC.CONSTRAINT_NAME "�������Ǹ�" , UC.TABLE_NAME "���̺��", UC.CONSTRAINT_TYPE "������������"
       ,UCC.COLUMN_NAME "�÷���"
FROM USER_CONS_COLUMNS UCC JOIN USER_CONSTRAINTS UC
 ON UCC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME
 WHERE UC.TABLE_NAME = 'TBL_TEST1'; 


--��PK ���� �ǽ�(�����̺� ������ ����)
CREATE TABLE TBL_TEST2
( COL1 NUMBER(5)
, COL2 VARCHAR(30)
, CONSTRAINT TEST2_COL1_PK PRIMARY KEY(COL1)
);

--������ �Է�
INSERT INTO TBL_TEST2(COL1, COL2) VALUES(1, 'TEST');
INSERT INTO TBL_TEST2(COL1, COL2) VALUES(1, 'ABCD'); --����
INSERT INTO TBL_TEST2(COL1, COL2) VALUES(2, 'ABCD');
INSERT INTO TBL_TEST2(COL1, COL2) VALUES(3, NULL);
INSERT INTO TBL_TEST2(COL1) VALUES(4);
INSERT INTO TBL_TEST2(COL1, COL2) VALUES(5, 'ABCD');
INSERT INTO TBL_TEST2(COL1, COL2) VALUES(NULL, 'TEST'); --����
INSERT INTO TBL_TEST2( COL2) VALUES('TEST'); --����

COMMIT;

SELECT *
FROM TBL_TEST2;
/*
1	TEST
2	ABCD
3	
4	
5	ABCD
*/

SELECT UC.OWNER "������" , UC.CONSTRAINT_NAME "�������Ǹ�" , UC.TABLE_NAME "���̺��", UC.CONSTRAINT_TYPE "������������"
       ,UCC.COLUMN_NAME "�÷���"
FROM USER_CONS_COLUMNS UCC , USER_CONSTRAINTS UC
 WHERE UCC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME
 AND UC.TABLE_NAME = 'TBL_TEST2'; 
--HR	TEST2_COL1_PK	TBL_TEST2	P	COL1

--��PK ���� �ǽ�(�� ���� �÷� PK ����)
CREATE TABLE TBL_TEST3
( COL1 NUMBER(5)
, COL2 VARCHAR2(30)
, CONSTRAINT TEST_COL1_COL2_PK PRIMARY KEY(COL1,COL2)
);
--==>>Table TBL_TEST3

--������ �Է�
INSERT INTO TBL_TEST3(COL1,COL2) VALUES(1,'TEST');
INSERT INTO TBL_TEST3(COL1,COL2) VALUES(1,'TEST'); -->���� �߻�
INSERT INTO TBL_TEST3(COL1,COL2) VALUES(1,'ABCD'); --�����ϴ�
--ù��° �÷��� �ι�° �÷��� ���� ���°� �ƴ�
--���̺��� PRIMARY KEY�� �ϳ���
--������ ������ ������ �ΰ��� �÷��� �ϳ��� ������� ���̱⿡ ��Ȯ�̴� ���� ���ļ� �����Ѵ�. �׷��� �� ������ �����Ѱ�
--1TEST VS 1ABCD �ΰ�
INSERT INTO TBL_TEST3(COL1,COL2) VALUES(2,'ABCD'); --����
INSERT INTO TBL_TEST3(COL1,COL2) VALUES(2,'TEST'); --����
INSERT INTO TBL_TEST3(COL1,COL2) VALUES(3,NULL); --�ȵ� �� �÷��� ���� NULL�� ��Ȳ�� Ȯ���Ѵ�.
INSERT INTO TBL_TEST3(COL1,COL2) VALUES(NULL,'TEST'); --�ȵ�
INSERT INTO TBL_TEST3(COL1,COL2) VALUES(NULL,NULL); --�ȵ�

COMMIT;

SELECT *
FROM TBL_TEST3;
/*
1	ABCD
1	TEST
2	ABCD
2	TEST
*/

SELECT UC.OWNER "������" , UC.CONSTRAINT_NAME "�������Ǹ�" , UC.TABLE_NAME "���̺��", UC.CONSTRAINT_TYPE "������������"
       ,UCC.COLUMN_NAME "�÷���"
FROM USER_CONS_COLUMNS UCC , USER_CONSTRAINTS UC
 WHERE UCC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME
 AND UC.TABLE_NAME = 'TBL_TEST3'; 
 /*
HR	TEST_COL1_COL2_PK	TBL_TEST3	P	COL1
HR	TEST_COL1_COL2_PK	TBL_TEST3	P	COL2
���� ������ �̸��� ���⿡ ���������� �ϳ��ΰ��̴�.
 */
 
 --���������� ���̺��� ������� �Ŀ��� �߰��� �� �ִ�.
 --��PK ���� �ǽ�(�����̺� ���� ���� �������� �߰� ����)
 --���̺� ����
 CREATE TABLE TBL_TEST4
( COL1 NUMBER(5)
, COL2 VARCHAR2(30)
);

--���̹� ������(������� �ִ�) ���̺�
-- �ο��Ϸ��� ���������� ������ �����Ͱ� ���ԵǾ� ���� ���
-- �ش� ���̺� ���������� �߰��� �� ����.

--�������� �߰�
ALTER TABLE TBL_TEST4
ADD CONSTRAINT TEST4_COL_PK PRIMARY KEY(COL1);
--��

--���������� Ȯ�� ���� ��(VIEW) ����
CREATE OR REPLACE VIEW VIEW_CONSTCHECK
AS
SELECT UC.OWNER "OWNER"
       , UC.CONSTRAINT_NAME "CONSTRAINT_NAME"
       , UC.TABLE_NAME "TABLE_NAME"
       , UC.CONSTRAINT_TYPE  "CONSTRAINT_TYPE"
       , UCC.COLUMN_NAME  "COLUMN_NAME"
       , UC.SEARCH_CONDITION  "SEARCH_CONDITION"
       , UC.DELETE_RULE  "DELETE_RULE"
FROM USER_CONSTRAINTS UC JOIN USER_CONS_COLUMNS UCC
ON UC.CONSTRAINT_NAME = UCC.CONSTRAINT_NAME;


--�ۻ����� ��VIEW �� ���� �������� Ȯ��
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_TEST4';
--HR	TEST4_COL_PK	TBL_TEST4	P	COL1
--------------------------------------------------------------


---����UNIQUE(UK:U)����---

--1. ���̺��� ������ �÷��� �����Ͱ� �ߺ����� �ʰ� ������ �� �ֵ��� �����ϴ� ��������
-- PRIMARY KEY�� ������ ��������������, NULL�� ����Ѵٴ� �������� �ִ�.
-- ���������� PRIMARY KEY�� ���������� UNIQUE INDEX�� �ڵ� �����ȴ�.
-- �ϳ��� ���̺� ������ UNIQUE ���������� ���� �� �����ϴ� ���� �����ϴ�.
-- ��, �ϳ��� ���̺� UNIQUE ���������� ���� �� ����� ���� �����ϴ� ���̴�.

--2.���� �� ����
--���÷� ������ ����
--�÷��� ������Ÿ�� [CONSTRAINT CONSTRAINT ��] UNIQUE

--�����̺� ������ ����
--�÷��� ������ Ÿ��,
--�÷��� ������ Ÿ��,
--CONSTRAINT CONSTRAINT�� UNIQUE(�÷���,...)


--UK �����ǽ�(���÷� ������ ����)
-- ���̺� ����
CREATE TABLE TBL_TEST5
( COL1 NUMBER(5)   PRIMARY KEY
, COL2 VARCHAR2(30)  UNIQUE
);

SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME='TBL_TEST5';
/*
HR	SYS_C007120	TBL_TEST5	P	COL1		
HR	SYS_C007121	TBL_TEST5	U	COL2		
*/

INSERT INTO TBL_TEST5(COL1, COL2) VALUES(1,'TEST');
INSERT INTO TBL_TEST5(COL1, COL2) VALUES(1,'TEST');-- ����
INSERT INTO TBL_TEST5(COL1, COL2) VALUES(2, 'ABCD');
INSERT INTO TBL_TEST5(COL1, COL2) VALUES(3, 'ABCD'); --���� UNIQUE �������� ����
--ORA-00001: unique constraint (HR.SYS_C007121) violated
INSERT INTO TBL_TEST5(COL1, COL2) VALUES(3, NULL);
INSERT INTO TBL_TEST5(COL1) VALUES(4);  --NULL�� �����Ͱ� �ƴϸ� UNIQUE�ϰ� ��������� ����
INSERT INTO TBL_TEST5(COL1, COL2) VALUES(5, 'ABCD'); --UNIQUE �������� �ȵ���

SELECT *
FROM TBL_TEST5;
/*
1	TEST
2	ABCD
3	
4	
*/

--�� UK ���� �ǽ�(�����̺� ������ ����)
--���̺� ����
CREATE TABLE TBL_TEST6
( COL1 NUMBER(5)
, COL2 VARCHAR2(30)
, CONSTRAINT TEST6_COL1_PK PRIMARY KEY(COL1)
, CONSTRAINT TEST6_COL2_UK UNIQUE(COL2)
);

SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_TEST6';
/*
HR	TEST6_COL1_PK	TBL_TEST6	P	COL1		
HR	TEST6_COL2_UK	TBL_TEST6	U	COL2		
*/

--��UK ���� �ǽ�(�����̺� ���� ���� �������� �߰�)
--���̺� ����
CREATE TABLE TBL_TEST7
( COL1 NUMBER(5)
, COL2 VARCHAR2(30)
);

--�������� Ȯ��
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_TEST7';

--�������� �߰�
ALTER TABLE TBL_TEST7
ADD CONSTRAINT TEST7_COL1_PK PRIMARY KEY(COL1);
--
SELECT *
FROM TBL_TEST5;

--�ѹ��� �ϱ�
ALTER TABLE TBL_TEST7
ADD (CONSTRAINT TEST7_COL2_UK UNIQUE(COL2)
   , CONSTRAINT TEST7_COL1_PK PRIMARY KEY(COL1));
   
   
--�������� �߰� ���� �ٽ� Ȯ��
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_TEST6';
/*
HR	TEST6_COL1_PK	TBL_TEST6	P	COL1		
HR	TEST6_COL2_UK	TBL_TEST6	U	COL2		
*/

--------------------------------------------

--���� CHECK(CK:C) ����--

--1.�÷����� ��� �����ѵ������� ������ ������ �����ϱ� ���� ��������
-- �÷��� �ԷµǴ� �����͸� �˻��Ͽ� ���ǿ� �´� �����͸� �Էµ� �� �ֵ��� �Ѵ�.
-- ����, �÷����� �����Ǵ� �����͸� �˻��Ͽ� ���ǿ� �´� �����ͷ� �����Ǵ� �͸�
-- ����ϴ� ����� �����ϰ� �ȴ�.


--2. ���Ĺ� ����
--���÷� ������ ����
--�÷��� ������Ÿ�� [CONSTRAINT CONSTRAINT ��] CHECK(�÷� ����)

--�����̺� ������ ����
--�÷��� ������ Ÿ��,
--�÷��� ������ Ÿ��,
--CONSTRAINT CONSTRAINT�� CHECK(�÷� ����)


--��CK ���� �ǽ�(���÷� ������ ����)
-- ���̺� ����
CREATE TABLE TBL_TEST8
( COL1 NUMBER(5)    PRIMARY KEY
, COL2 VARCHAR2(30)
, COL3 NUMBER(3)    CHECK (COL3 BETWEEN 0 AND 100)
);

--������ �Է�
INSERT INTO TBL_TEST8(COL1, COL2,COL3) VALUES(1, '������',100);
INSERT INTO TBL_TEST8(COL1, COL2,COL3) VALUES(1, '������',100); --���� PRIMARY KEY
INSERT INTO TBL_TEST8(COL1, COL2,COL3) VALUES(2, '������',101); -- ���� CHECK ���� �ʰ�
INSERT INTO TBL_TEST8(COL1, COL2,COL3) VALUES(2, '������',-1);
INSERT INTO TBL_TEST8(COL1, COL2,COL3) VALUES(2, '������',80);

--�������� Ȯ��
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_TEST8';
/*
HR	SYS_C007124	TBL_TEST8	C	COL3	COL3 BETWEEN 0 AND 100	
HR	SYS_C007125	TBL_TEST8	P	COL1		
SEARCH_CONDITION �� ������ ���ִ�.
*/

--��CK �����ǽ�(�����̺� ������ ����)
-- ���̺� ����
CREATE TABLE TBL_TEST9
( COL1 NUMBER(5)
, COL2 VARCHAR2(30)
, COL3 NUMBER(3)
, CONSTRAINT TEST9_COL1_PK PRIMARY KEY(COL1)
, CONSTRAINT TEST9_COL3_CK CHECK (COL3 BETWEEN 0 AND 100)
);


INSERT INTO TBL_TEST9(COL1, COL2,COL3) VALUES(1, '������',100);
INSERT INTO TBL_TEST9(COL1, COL2,COL3) VALUES(1, '������',100); --���� PRIMARY KEY
INSERT INTO TBL_TEST9(COL1, COL2,COL3) VALUES(2, '������',101); -- ���� CHECK ���� �ʰ�
INSERT INTO TBL_TEST9(COL1, COL2,COL3) VALUES(2, '������',-1);
INSERT INTO TBL_TEST9(COL1, COL2,COL3) VALUES(2, '������',80);

--���� ����
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME='TBL_TEST9';
/*
HR	TEST9_COL3_CK	TBL_TEST9	C	COL3	COL3 BETWEEN 0 AND 100	
HR	TEST9_COL1_PK	TBL_TEST9	P	COL1		
*/

--��CK ���� �ǽ�(�����̺� ���� ���� �������� �߰�)
--���̺� ����
CREATE TABLE TBL_TEST10
( COL1 NUMBER(5)
, COL2 VARCHAR2(30)
, COL3 NUMBER(3)
);

--==>>Table TBL_TEST10�� �����Ǿ����ϴ�.

--�������� Ȯ��
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_TEST10';

--�������� �߰�
ALTER TABLE TBL_TEST10
ADD (CONSTRAINT TEST10_COL1_PK PRIMARY KEY(COL1)
    ,CONSTRAINT TEST10_COL3_CK CHECK (COL3 BETWEEN 0 AND 100));
--����

--�������� Ȯ��
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_TEST10';
/*
HR	TEST10_COL1_PK	TBL_TEST10	P	COL1		
HR	TEST10_COL3_CK	TBL_TEST10	C	COL3	COL3 BETWEEN 0 AND 100	
*/

--���̺� ����
CREATE TABLE TBL_TESTMEMBER
( SID NUMBER
, NAME VARCHAR2(30)
, SSN CHAR(14)
, TEL VARCHAR2(40)
);

--��TBL_TESTMEMBER ���̺��� SSN �÷�(�ֹε�Ϲ�ȣ �÷�)����
-- ������ �Է��̳� ���� ��, ������ ��ȿ�� �����͸� �Էµ� �� �ֵ���
--üũ ���������� �߰��� �� �ֵ��� �Ѵ�.
-- (->�ֹι�ȣ Ư�� �ڸ��� �Է� ������ �����͸� 1,2,3,4�� ����)
-- ����, SID �÷����� PRIMARY KEY ���������� ������ �� �ֵ��� �Ѵ�.

ALTER TABLE TBL_TESTMEMBER
ADD (CONSTRAINT TESTMEMBER_SID_PK PRIMARY KEY(SID)
    ,CONSTRAINT TESTMEMBER_SSN_CK CHECK (SUBSTR(SSN,7,1) IN ('1','2','3','4')));

--���� ������ �߸� �����ߴٸ�
--ALTER���� ADD ��� DROP�̰� ���������� �̸��� ���� �ȴ�. UPDATE�� �ȵȴ�.

ALTER TABLE TBL_TESTMEMBER
DROP CONSTRAINT TESTMEMBER_SSN_CK;

ALTER TABLE TBL_TESTMEMBER
ADD CONSTRAINT TESTMEMBER_SSN_CK CHECK (SUBSTR(SSN,8,1) IN ('1','2','3','4'));


SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_TESTMEMBER';
/*
HR	TESTMEMBER_SID_PK	TBL_TESTMEMBER	P	SID		
HR	TESTMEMBER_SSN_CK	TBL_TESTMEMBER	C	SSN	SUBSTR(SSN,7,1) IN ('1','2','3','4')	
*/

--������ �Է� �׽�Ʈ
INSERT INTO TBL_TESTMEMBER(SID, NAME, SSN, TEL)
VALUES(1, '���ҿ�' , '941124-2234567', '010-1111-1111');

INSERT INTO TBL_TESTMEMBER(SID, NAME, SSN, TEL)
VALUES(2, '�ֵ���' , '950222-1234567', '010-2222-2222');

INSERT INTO TBL_TESTMEMBER(SID, NAME, SSN, TEL)
VALUES(3, '������' , '040601-3234567', '010-3333-3333');

INSERT INTO TBL_TESTMEMBER(SID, NAME, SSN, TEL)
VALUES(4, '������' , '050215-4234567', '010-4444-4444');

INSERT INTO TBL_TESTMEMBER(SID, NAME, SSN, TEL)
VALUES(5, '�ڿ���' , '980301-5234567', '010-5555-5555');
--ORA-02290: check constraint (HR.TESTMEMBER_SSN_CK) violated

SELECT *
FROM TBL_TESTMEMBER;
/*
1	���ҿ�	941124-2234567	010-1111-1111
2	�ֵ���	950222-1234567	010-2222-2222
3	������	040601-3234567	010-3333-3333
4	������	050215-4234567	010-4444-4444
*/

COMMIT;

--------------------------------------------------------------

--���� FOREIGN KEY(FK:F:R) ����----

--1. ���� Ű(R) �Ǵ� �ܷ� Ű(FK:F) �� �� ���̺��� �����Ͱ� ������ �����ϰ�
-- ���� �����Ű�µ� ���Ǵ� ���̴�.
-- �����̺��� �⺻ Ű ���� �ִ� ����
-- �ٸ� ���̺� �߰��ϸ� ���̺� �� ������ ������ �� �ִ�.
-- �̶�, �� ��° ���̺�(�ڽ� ���̺�)�� �߰��Ǵ� ���� �ܷ�Ű�� �ȴ�.

--2.�θ� ���̺�(�����޴� �÷��� ���Ե� ���̺�)�� ���� ������ ��
-- �ڽ� ���̺�(�����ϴ� �÷��� ���Ե� ���̺�)�� �����Ǿ�� �Ѵ�.
-- �̶�, �ڽ� ���̺� FOREIGN KEY ���������� �����ȴ�.

--3. ���� �� ����
-- ���÷� ������ ����
-- �÷��� ������ Ÿ��[ CONSTRAINT CONSTRAINT��]
                    --REFERENCES �������̺��(�����÷���)
                    --[ON DELETE CASCADE | ON DELETE SET NULL] -->�߰��ɼ�
                    
-- �����̺� ������ ����
-- �÷��� ������ Ÿ��
-- �÷��� ������ Ÿ��
--[ CONSTRAINT CONSTRAINT�� FOREIGN KEY(�÷���)
                    --REFERENCES �������̺��(�����÷���)
                    --[ON DELETE CASCADE | ON DELETE SET NULL] -->�߰��ɼ�

--��FOREIGN KEY ���������� �����ϴ� �ǽ��� �����ϱ� ���ؼ���
-- �θ� ���̺��� ���� �۾��� ���� �����ؾ� �Ѵ�.
-- �׸��� �� ��, �θ� ���̺��� �ݵ�� PK�Ǵ� UK ����������
-- ������ �÷��� �����ؾ� �Ѵ�. 

CREATE TABLE TBL_JOBS
( JIKWI_ID NUMBER
, JIKWI_NAME VARCHAR2(30)
, CONSTRAINT JOBS_ID_PK PRIMARY KEY(JIKWI_ID)
);

--������

--������ �Է�
INSERT INTO TBL_JOBS(JIKWI_ID, JIKWI_NAME) VALUES(1,'���');
INSERT INTO TBL_JOBS(JIKWI_ID, JIKWI_NAME) VALUES(2,'�븮');
INSERT INTO TBL_JOBS(JIKWI_ID, JIKWI_NAME) VALUES(3,'����');
INSERT INTO TBL_JOBS(JIKWI_ID, JIKWI_NAME) VALUES(4,'����');
--������ �Է�

SELECT *
FROM TBL_JOBS;

COMMIT;

--��FK ���� �ǽ�(���÷� ������ ����)
--���̺� ����
CREATE TABLE TBL_EMP1
(SID  NUMBER         PRIMARY KEY
, NAME VARCHAR2(30)
, JIKWI_ID NUMBER    REFERENCES TBL_JOBS(JIKWI_ID) --
);

--NUMBER ���� ���������� ���Ѵٸ� NUMBER�� ǥ�������� �پ��ٴ� �Ű�
--CHAR ���� ���������� ���Ѵٸ� 1���� ���ڸ� �ǹ��Ѵ�.


--�������� Ȯ��
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_EMP1';
/*
HR	SYS_C007134	TBL_EMP1	P	SID		
HR	SYS_C007135	TBL_EMP1	R	JIKWI_ID		NO ACTION --NO ACTION �� ������ ���� �߰��ɼǿ� ���Ѱ�
*/

--������ �Է�
INSERT INTO TBL_EMP1(SID, NAME, JIKWI_ID) VALUES(1, '���̰�', 1);
INSERT INTO TBL_EMP1(SID, NAME, JIKWI_ID) VALUES(2, '�ֳ���', 2);
INSERT INTO TBL_EMP1(SID, NAME, JIKWI_ID) VALUES(3, '������', 3);
INSERT INTO TBL_EMP1(SID, NAME, JIKWI_ID) VALUES(4, '������', 4);

INSERT INTO TBL_EMP1(SID, NAME, JIKWI_ID) VALUES(5, '����', 5);
--ORA-02291: integrity constraint (HR.SYS_C007135) violated - parent key not found
--�θ��� �����޴� �÷��� �ش� ������ 5�� �������� ����
INSERT INTO TBL_EMP1(SID, NAME, JIKWI_ID) VALUES(5, '����', 1);
INSERT INTO TBL_EMP1(SID, NAME) VALUES(6, '���¹�');

SELECT *
FROM TBL_EMP1;
/*
1	���̰�	1
2	�ֳ���	2
3	������	3
4	������	4
5	����	1
6	���¹�	
*/

COMMIT;


--��FK ���� �ǽ�(�����̺� ������ ����)
--���̺� ����
CREATE TABLE TBL_EMP2
( SID NUMBER
, NAME VARCHAR2(30)
, JIKWI_ID NUMBER
, CONSTRAINT EMP2_SID_PK PRIMARY KEY(SID)
, CONSTRAINT EMP2_JIKWI_ID_FK FOREIGN KEY(JIKWI_ID)
             REFERENCES TBL_JOBS(JIKWI_ID)
);

SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_EMP2';
/*
HR	EMP2_SID_PK	TBL_EMP2	P	SID		
HR	EMP2_JIKWI_ID_FK	TBL_EMP2	R	JIKWI_ID		NO ACTION
*/

--��FK ���� �ǽ�(�����̺� ������ ����)
--���̺� ����
CREATE TABLE TBL_EMP3
( SID NUMBER
, NAME VARCHAR2(30)
, JIKWI_ID NUMBER
);

--�������� �߰�
ALTER TABLE TBL_EMP3
ADD( CONSTRAINT EMP3_SID_PK PRIMARY KEY(SID)
    ,CONSTRAINT EMP3_JIKWI_ID_FK FOREIGN KEY(JIKWI_ID)
               REFERENCES TBL_JOBS(JIKWI_ID));
    );

ALTER TABLE TBL_EMP3
ADD CONSTRAINT EMP3_JIKWI_ID_FK FOREIGN KEY(JIKWI_ID)
               REFERENCES TBL_JOBS(JIKWI_ID);

    
--�������� ����
ALTER TABLE TBL_EMP3
DROP CONSTRAINT EMP3_JIKWI_ID_FK;


--�������� Ȯ��
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_EMP3';
--HR	EMP3_SID_PK	TBL_EMP3	P	SID		

--�ٽ� �������� �߰�
ALTER TABLE TBL_EMP3
ADD CONSTRAINT EMP3_JIKWI_ID_FK FOREIGN KEY(JIKWI_ID)
               REFERENCES TBL_JOBS(JIKWI_ID);

SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_EMP3';
/*
HR	EMP3_SID_PK	TBL_EMP3	P	SID		
HR	EMP3_JIKWI_ID_FK	TBL_EMP3	R	JIKWI_ID		NO ACTION
*/

--4. FOREIGN KEY ���� �� ���ǻ���
-- �����ϰ��� �ϴ� �θ� ���̺��� ���� �����ؾ� �Ѵ�.
-- �����ϰ��� �ϴ� �÷��� PRIMARY KEY�Ǵ� UNIQUE ���������� �����Ǿ� �־�� �Ѵ�.
-- ���̺� ���̿� PRIMARY KEY�� FOREIGN KEY�� ���ǵǾ� ������
-- PRIMARY KEY ���������� ������ ������ ���� ��
-- FOREIGN KEY �÷��� �ش� ���� �ԷµǾ� �ִ� ��� ���� ���� �ʴ´�.
-- �� �ڽ����̺� �����ϴ� ���ڵ尡 ������ ���
-- �θ� ���̺��� �����޴� �ش� ���ڵ�� ������ �� ���ٴ� ���̴�.
-- ��, FK �����ϴ� �������� ��ON DELECT CASCADE����  ��ON DELECT SET NULL���ɼ���
-- ����Ͽ� ������ ��쿡�� ������ �����ϴ�.
-- �� �̰�� �����Ѵٸ� �ڽ����̺��� �θ����̺��� ������ �����Ϳ� ������ �����͵��� ���� �����ȴ�.
-- ����, �θ� ���̺��� �����ϱ� ���ؼ��� �ڽ� ���̺��� ���� �����ؾ� �Ѵ�.
-- �̴� ���Ἲ�� ��ġ�� �ʱ����ؼ���

-- �θ� ���̺�
SELECT *
FROM TBL_JOBS;
--==>>
/*
1	���
2	�븮
3	����
4	����
*/

--�ڽ� ���̺�
SELECT *
FROM TBL_EMP1;
--==>>
/*
1	���̰�	1
2	�ֳ���	2
3	������	3
4	������	4
5	����	1
6	���¹�	
*/

--�θ� ���̺� ���� �õ�
DROP TABLE TBL_JOBS; --�����߻�


--�θ� ���̺��� ���� ���� ���� �õ�

SELECT *
FROM TBL_JOBS
WHERE JIKWI_ID = 4;
--4	����


DELETE 
FROM TBL_JOBS
WHERE JIKWI_ID = 4;
--ORA-02292: integrity constraint (HR.SYS_C007135) violated - child record found
--�ڽĿ��� �����Ϸ��� �����͸� ������ �ִ�.


-- ������ ������ ������ ������� ����
UPDATE TBL_EMP1
SET JIKWI_ID = 1
WHERE SID = 4;

SELECT *
FROM TBL_EMP1;

COMMIT;

--�θ� ���̺�(TBL_JOBS)�� ���� �����͸� �����ϰ� �ִ�
-- �ڽ� ���̺�(TBL_EMP1)�� �����Ͱ� �������� �ʴ� ��Ȳ

--�̿� ���� ��Ȳ���� �θ� ���̺�(TBL_JOBS)�� ���嵥���� ����

DELETE 
FROM TBL_JOBS
WHERE JIKWI_ID = 4;
--1 �� ��(��) �����Ǿ����ϴ�.

SELECT *
FROM TBL_JOBS;
/*
1	���
2	�븮
3	����
*/

COMMIT;

--�θ� ���̺�(TBL_JOBS)�� ��� ������ ����
DELETE
FROM TBL_JOBS
WHERE JIKWI_ID = 1;
--ORA-02292: integrity constraint (HR.SYS_C007135) violated - child record found

--�غθ� ���̺��� �����͸� �����Ӱ�(?) �����ϱ� ���ؼ���
-- ��ON DELETE CASCADE�� �ɼ� ������ �ʿ��ϴ�.

--TBL_EMP1 ���̺�(�ڽ� ���̺�)���� FK ���������� ������ ��
-- CASCADE �ɼ��� �����Ͽ� �ٽ� FK ���������� �����Ѵ�.


--�������� Ȯ��
SELECT *
FROM VIEW_CONSTCHECK
WHERE  TABLE_NAME = 'TBL_EMP1';
--==>>
/*
HR	SYS_C007134	TBL_EMP1	P	SID		
HR	SYS_C007135	TBL_EMP1	R	JIKWI_ID		NO ACTION
*/

--�������� ����
ALTER TABLE TBL_EMP1
DROP CONSTRAINT SYS_C007135;
--Table TBL_EMP1��(��) ����Ǿ����ϴ�.

--�������� ���� ���� �ٽ� Ȯ��
SELECT *
FROM VIEW_CONSTCHECK
WHERE  TABLE_NAME = 'TBL_EMP1';

--ON DELETE CASCADE �ɼ��� ���Ե� �������� �������� �ٽ� ����
ALTER TABLE TBL_EMP1
ADD CONSTRAINT EMP1_JIKWI_ID_FK FOREIGN KEY(JIKWI_ID)
                REFERENCES TBL_JOBS(JIKWI_ID)
                ON DELETE CASCADE;
                
--==>> Table TBL_EMP1 ����Ǿ����ϴ�.

--�������� ���� ���� �ٽ� Ȯ��
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_EMP1';

--�� CASCADE �ɼ��� ������ �Ŀ���
-- �����ް� �ִ� �θ� ���̺��� �����͸�
-- �������� �����Ӱ� �����ϴ� ���� �����ϴ�.
-- ��,....�θ� ���̺��� �����Ͱ� ������ ���...
-- �̸� �����ϴ� �ڽ� ���̺��� �����͵� ��� �Բ� �����ȴ�.

SELECT *
FROM TBL_JOBS;
/*
1	���
2	�븮
3	����
*/
SELECT *
FROM TBL_EMP1;
/*
1	���̰�	1
2	�ֳ���	2
3	������	3
4	������	1
5	����	1
6	���¹�	
*/

--�θ����̺�(TBL_JOBS)���� ���� ������ ����
DELETE
FROM TBL_JOBS
WHERE JIKWI_ID=3;

SELECT *
FROM TBL_EMP1;
/*
1	���̰�	1
2	�ֳ���	2
4	������	1
5	����	1
6	���¹�	
*/
-- ������ �����Ͱ� �����

--�θ����̺�(TBL_JOBS)���� ��� ������ ����
DELETE
FROM TBL_JOBS
WHERE JIKWI_ID=1;
--1 �� ��(��) �����Ǿ����ϴ�.

SELECT *
FROM TBL_EMP1;
/*
2	�ֳ���	2
6	���¹�	
*/
--��� ����� �����Ͱ� ����

DROP TABLE TBL_EMP2;
DROP TABLE TBL_EMP3;

DROP TABLE TBL_JOBS; --EMP1������ ���Ű� �ȵ�

DROP TABLE TBL_EMP1;

DROP TABLE TBL_JOBS;

COMMIT;