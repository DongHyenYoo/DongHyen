SELECT USER
FROM DUAL;


--���� ����Ŭ ��ȣȭ&��ȣȭ01_SYS ����--

/*
��ȣȭ�� ���Ұ��� �� 3�ڰ� ��������� �����Ұ��ϰ� �ϴ°�
��ȣȭ�� ��ȣȭ�� �����͸� �����ְ� �����ϴ� ��������
�̰� Ư�� �˰��� ���Ѱ��� �Ϲ��ε� �����Ҽ��ִ�.


1.����Ŭ ��ȣȭ ����� ����ϱ� ���ؼ���
 ��DBMS_OBFUSCATION_TOOLKIT�� ��Ű���� �̿��Ѵ�.
  ��ȣȭ, ��ȣȭ �˰����� ���� �����ϴ� �͵� �����ϴ�.
  ������, ���ǻ� ����Ŭ���� �������ִ� ��Ű���� ���� ������ �� �ִ�.
  
2.��DBMS_OBFUSCATION_TOOLKIT�� ��Ű����
  �⺻������ ����� �� ���� ���·� �����Ǿ��ִ�. (DEFAULT ���� ��)
   �� ��Ű���� ����ϱ� ���ؼ��� �߰� ��ġ ������ �ʿ��ϴ�.
   (dbmsobtk.sql, prvtobtk.plb ������ ã�Ƽ� ������ �� �ֵ��� �Ѵ�.)


3. �� ��Ű���� 4���� ���ν����� �̷���� �ִ�.
VARCHAR2 Ÿ���� Encrypt/Decrypt �� �� �ִ� 2���� ���ν���
RAW Ÿ���� Encrypt/Decrypt �� �� �ִ� 2���� ���ν���
(�ٸ� Ÿ���� �������� �ʱ� ������ NUMBER Ÿ���� ��� TO_CHAR ���)

�� RAW, LONG RAW, ROWID Ÿ��
 �׷��� �̹����� ������ ���带 ����
 HEXA-DECEMAL(16 ����) ���·� RETURN
 RAW �� VARCHAR2 �� ����
 LONG RAW �� LONG �� �����ϳ� ������ ���� ���ѻ����� �ִ�.
  - ����� ���⸸ �����ϰ�, �����͸� ������ �� ����.
  - LONG RAW�� LONG �� ���� ���� ������ ���´�.
 
*/


--�۾�ȣȭ ��ȣȭ ��Ű�� ��ġ

/*
C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin

@C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin\dbmsobtk.sql

@C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin\prvtobtk.plb
*/


--�� SCOTT ������ �� ��Ű���� ����� �� �ִ� ���� �ο� (SYS��..)
GRANT EXECUTE ON DBMS_OBFUSCATION_TOOLKIT TO SCOTT;
--Grant��(��) �����߽��ϴ�.