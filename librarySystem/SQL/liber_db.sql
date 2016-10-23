--create the database "liber_db"
BEGIN
   DECLARE @db NVARCHAR(255);
   SET @db = N'liber_db';

   USE master;

   -- Create the database if it doesn't exist.
   IF NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = @db)
      EXECUTE('CREATE DATABASE ' + @db);
   -- Uncomment to create with case-sensitive collation   
   --IF NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = @db) 
   --   EXECUTE('CREATE DATABASE ' + @db + ' COLLATE Latin1_General_BIN');
      

   -- Make sure columns default to NULL-able.
   EXECUTE('ALTER DATABASE ' + @db + ' SET ANSI_NULL_DEFAULT ON');
END;
GO


USE liber_db
GO
/****** Object:  Table [dbo].[operator_t]    Script Date: 06/15/2010 16:24:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[operator_t](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[password] [varchar](50) NULL,
	[system] [tinyint] NULL,
	[reader] [tinyint] NULL,
	[book] [tinyint] NULL,
	[borrow] [tinyint] NULL,
	[query] [tinyint] NULL,
 CONSTRAINT [PK_manager_t] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[operator_t] ON
INSERT [dbo].[operator_t] ([id], [name], [password], [system], [reader], [book], [borrow], [query]) VALUES (25, N'admin', N'admin', 1, 1, 1, 1, 1)
INSERT [dbo].[operator_t] ([id], [name], [password], [system], [reader], [book], [borrow], [query]) VALUES (26, N'user1', N'fDbCBCvFmcyYPT', 0, 0, 0, 0, 0)
SET IDENTITY_INSERT [dbo].[operator_t] OFF
/****** Object:  Table [dbo].[liberInfo_t]    Script Date: 06/15/2010 16:24:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[liberInfo_t](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[liberName] [varchar](50) NULL,
	[curator] [varchar](50) NULL,
	[tel] [varchar](50) NULL,
	[address] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[url] [varchar](50) NULL,
	[buildDate] [datetime] NULL,
	[introduce] [text] NULL,
 CONSTRAINT [PK_liberInfo_t] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[liberInfo_t] ON
INSERT [dbo].[liberInfo_t] ([id], [liberName], [curator], [tel], [address], [email], [url], [buildDate], [introduce]) VALUES (1, N'��������ҵ��ѧ��������ͼ���', N'������', N'06315687496', N'ɽ��ʡ�������Ļ���·2��', N'library@hit.edu.cn', N'http://lib.hitwh.edu.cn/', CAST(0x00008D1900000000 AS DateTime), N' ������������ͼ��ݴ����� 1988 �꣬�����������ᣬ������� 7842 ƽ���� ������ 4 ���鿯�����ң� 2 ����⣬ 1 ����������ҡ� 1 �������ҡ����������Ĳ��� 40 ����ᣬ �������ڿ� 1800 ���֣���ֽ 80 ���֣� �������� 2700 ������Թ����������ø������ݿ� 40 ���������ͼ�� 90 ����ᡣ 

    2003���������Զ�������ϵͳ��ȫ��ʵ���˲ɷá���Ŀ����ء���ͨ�����������������ѯ���Զ������� ���Ⱥ����� 128 ��������������ң� 24 �������豸�� 30 �����������ң������˸�¼������¼������ӡ������ӡ���ȹ����նˣ������γ���һ������Ϣ����Ϊ���ĵ��ܹ��ṩͼ����ġ��ο���ѯ�����׼������ݼʻ��衢���׸��ơ�ԭ�Ĵ��ݵȶ������͡����ε����׷�����ϵ�� 
')
SET IDENTITY_INSERT [dbo].[liberInfo_t] OFF
/****** Object:  Table [dbo].[booktype_t]    Script Date: 06/15/2010 16:24:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[booktype_t](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
 CONSTRAINT [PK_booktype_t] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[booktype_t] ON
INSERT [dbo].[booktype_t] ([id], [name]) VALUES (15, N'java���')
INSERT [dbo].[booktype_t] ([id], [name]) VALUES (16, N'java����')
INSERT [dbo].[booktype_t] ([id], [name]) VALUES (17, N'C++')
INSERT [dbo].[booktype_t] ([id], [name]) VALUES (19, N'�����')
INSERT [dbo].[booktype_t] ([id], [name]) VALUES (20, N'����')
INSERT [dbo].[booktype_t] ([id], [name]) VALUES (21, N'��ѧ')
INSERT [dbo].[booktype_t] ([id], [name]) VALUES (22, N'���Ŀ�ѧ')
SET IDENTITY_INSERT [dbo].[booktype_t] OFF
/****** Object:  Table [dbo].[readerType_t]    Script Date: 06/15/2010 16:24:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[readerType_t](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[quantity] [int] NULL,
 CONSTRAINT [PK_readerType_d] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[readerType_t] ON
INSERT [dbo].[readerType_t] ([id], [name], [quantity]) VALUES (14, N'��ͨ��Ա', 3)
INSERT [dbo].[readerType_t] ([id], [name], [quantity]) VALUES (15, N'�߼���Ա', 6)
SET IDENTITY_INSERT [dbo].[readerType_t] OFF
/****** Object:  Table [dbo].[reader_t]    Script Date: 06/15/2010 16:24:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[reader_t](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[password] [varchar](50) NULL,
	[identiCode] [varchar](50) NULL,
	[realName] [varchar](50) NULL,
	[sex] [tinyint] NULL,
	[papertype] [varchar](50) NULL,
	[paperNo] [varchar](50) NULL,
	[tel] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[registTime] [datetime] NULL,
	[description] [varchar](200) NULL,
	[operator] [int] NULL,
	[type] [int] NULL,
 CONSTRAINT [PK_reader_t] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[reader_t] ON
INSERT [dbo].[reader_t] ([id], [name], [password], [identiCode], [realName], [sex], [papertype], [paperNo], [tel], [email], [registTime], [description], [operator], [type]) VALUES (42, N'reader', N'000000', N'20100615162112042', N'����', 1, N'ѧ��֤', N'071110310', N'06315694787', N'a@d.com', CAST(0x00009B50010D7F6C AS DateTime), N'��ͨ��Ա', 25, 14)
INSERT [dbo].[reader_t] ([id], [name], [password], [identiCode], [realName], [sex], [papertype], [paperNo], [tel], [email], [registTime], [description], [operator], [type]) VALUES (43, N'reader2', N'000000', N'20100615164020043', N'����', 1, N'����֤', N'0779087822', N'06311111111', N'ss@s.cn', CAST(0x00009B500112C09C AS DateTime), N'�߼���Ա', 25, 15)
INSERT [dbo].[reader_t] ([id], [name], [password], [identiCode], [realName], [sex], [papertype], [paperNo], [tel], [email], [registTime], [description], [operator], [type]) VALUES (44, N'reader3', N'000000', N'20100615085329019', N'����', 0, N'���֤', N'390213198811112908', N'06315874563', N'ww@w.cn', CAST(0x00009B5100928742 AS DateTime), N'�߼���Ա', 25, 15)
INSERT [dbo].[reader_t] ([id], [name], [password], [identiCode], [realName], [sex], [papertype], [paperNo], [tel], [email], [registTime], [description], [operator], [type]) VALUES (45, N'reader4', N'000000', N'20100615090502045', N'����', 1, N'ѧ��֤', N'071110316', N'06315694736', N'hitlk@163.com', CAST(0x00009D960095B3C3 AS DateTime), N'�߼���Ա', 25, 15)
SET IDENTITY_INSERT [dbo].[reader_t] OFF
/****** Object:  Table [dbo].[book_t]    Script Date: 06/15/2010 16:24:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[book_t](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bookName] [varchar](50) NULL,
	[author] [varchar](50) NULL,
	[publisher] [varchar](50) NULL,
	[price] [float] NULL,
	[inTime] [datetime] NULL,
	[type] [int] NULL,
	[operator] [int] NULL,
 CONSTRAINT [PK_book_t] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[book_t] ON
INSERT [dbo].[book_t] ([id], [bookName], [author], [publisher], [price], [inTime], [type], [operator]) VALUES (28, N'Struts2���ļ�����JavaEE', N'����Ƽ�', N'���ӹ�ҵ', 89.5, CAST(0x00009D9501752944 AS DateTime), 15, 25)
INSERT [dbo].[book_t] ([id], [bookName], [author], [publisher], [price], [inTime], [type], [operator]) VALUES (29, N'C++����', N'Ralph', N'�廪��ѧ������', 55, CAST(0x00009D9501752944 AS DateTime), 17, 25)
INSERT [dbo].[book_t] ([id], [bookName], [author], [publisher], [price], [inTime], [type], [operator]) VALUES (30, N'java����', N'Jack', N'�ߵȽ���������', 35, CAST(0x00009D9501752944 AS DateTime), 16, 25)
INSERT [dbo].[book_t] ([id], [bookName], [author], [publisher], [price], [inTime], [type], [operator]) VALUES (31, N'��������ԭ���ڶ��棩', N'��˷��', N'�ߵȽ���������', 28.5, CAST(0x00009D9501752944 AS DateTime), 19, 25)
INSERT [dbo].[book_t] ([id], [bookName], [author], [publisher], [price], [inTime], [type], [operator]) VALUES (32, N'����ԭ��', N'������', N'��е���̳�����', 65.5, CAST(0x00009D9501752944 AS DateTime), 19, 25)
INSERT [dbo].[book_t] ([id], [bookName], [author], [publisher], [price], [inTime], [type], [operator]) VALUES (33, N'��׼�ձ���', N'���', N'�й��������������', 29.6, CAST(0x00009D9501752944 AS DateTime), 19, 25)
INSERT [dbo].[book_t] ([id], [bookName], [author], [publisher], [price], [inTime], [type], [operator]) VALUES (34, N'��ɢ��ѧ', N'����', N'�廪��ѧ������', 20.9, CAST(0x00009D9500000000 AS DateTime), 19, 25)
INSERT [dbo].[book_t] ([id], [bookName], [author], [publisher], [price], [inTime], [type], [operator]) VALUES (35, N'���������', N'лϣ��', N'���ӹ�ҵ������', 12.3, CAST(0x00009D9501752944 AS DateTime), 19, 25)
INSERT [dbo].[book_t] ([id], [bookName], [author], [publisher], [price], [inTime], [type], [operator]) VALUES (37, N'��׼������', N'�ų�', N'������ѧ������', 22.899999618530273, CAST(0x00009D9501752944 AS DateTime), 20, 25)
INSERT [dbo].[book_t] ([id], [bookName], [author], [publisher], [price], [inTime], [type], [operator]) VALUES (38, N'���ģʽ', N'James', N'�й�����������', 43.3, CAST(0x00009D9501752944 AS DateTime), 19, 25)
INSERT [dbo].[book_t] ([id], [bookName], [author], [publisher], [price], [inTime], [type], [operator]) VALUES (39, N'.net', N'���ΰ', N'�廪��ѧ������', 23.3, CAST(0x00009D9501752944 AS DateTime), 19, 25)
SET IDENTITY_INSERT [dbo].[book_t] OFF
/****** Object:  Table [dbo].[barcode_t]    Script Date: 06/15/2010 16:24:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[barcode_t](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[barcode] [varchar](50) NULL,
	[bookid] [int] NULL,
 CONSTRAINT [PK_barcode_t] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[barcode_t] ON
INSERT [dbo].[barcode_t] ([id], [barcode], [bookid]) VALUES (74, N'015028002', 28)
INSERT [dbo].[barcode_t] ([id], [barcode], [bookid]) VALUES (75, N'017029001', 29)
INSERT [dbo].[barcode_t] ([id], [barcode], [bookid]) VALUES (78, N'016030002', 30)
INSERT [dbo].[barcode_t] ([id], [barcode], [bookid]) VALUES (92, N'019031001', 31)
INSERT [dbo].[barcode_t] ([id], [barcode], [bookid]) VALUES (93, N'019032001', 32)
INSERT [dbo].[barcode_t] ([id], [barcode], [bookid]) VALUES (94, N'020033001', 33)
INSERT [dbo].[barcode_t] ([id], [barcode], [bookid]) VALUES (95, N'019034001', 34)
INSERT [dbo].[barcode_t] ([id], [barcode], [bookid]) VALUES (96, N'019035001', 35)
INSERT [dbo].[barcode_t] ([id], [barcode], [bookid]) VALUES (99, N'019038001', 38)
INSERT [dbo].[barcode_t] ([id], [barcode], [bookid]) VALUES (100, N'019039001', 39)
INSERT [dbo].[barcode_t] ([id], [barcode], [bookid]) VALUES (101, N'020037001', 37)
SET IDENTITY_INSERT [dbo].[barcode_t] OFF
/****** Object:  Table [dbo].[borrow_t]    Script Date: 06/15/2010 16:24:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[borrow_t](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[borrowTime] [datetime] NULL,
	[readerid] [int] NULL,
	[bookid] [int] NULL,
	[borrowOperator] [int] NULL,
	[renew] [tinyint] NULL,
	[forceBackTime] [datetime] NULL,
	[giveback] [tinyint] NULL,
	[givebackOperator] [int] NULL,
	[givebackTime] [datetime] NULL,
 CONSTRAINT [PK_borrow] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[borrow_t] ON
INSERT [dbo].[borrow_t] ([id], [borrowTime], [readerid], [bookid], [borrowOperator], [renew], [forceBackTime], [giveback], [givebackOperator], [givebackTime]) VALUES (28, CAST(0x00009D9600988831 AS DateTime), 45, 100, 25, 0, CAST(0x00009DB400988831 AS DateTime), 0, NULL, NULL)
INSERT [dbo].[borrow_t] ([id], [borrowTime], [readerid], [bookid], [borrowOperator], [renew], [forceBackTime], [giveback], [givebackOperator], [givebackTime]) VALUES (29, CAST(0x00009D960098967F AS DateTime), 45, 99, 25, 1, CAST(0x00009DB40098967F AS DateTime), 1, 25, CAST(0x00009D960098CD1A AS DateTime))
SET IDENTITY_INSERT [dbo].[borrow_t] OFF
/****** Object:  Default [DF_reader_t_loginTime]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[reader_t] ADD  CONSTRAINT [DF_reader_t_loginTime]  DEFAULT (getdate()) FOR [registTime]
GO
/****** Object:  Default [DF_reader_t_type]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[reader_t] ADD  CONSTRAINT [DF_reader_t_type]  DEFAULT ((1)) FOR [type]
GO
/****** Object:  Default [DF_borrow_borrowTime]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t] ADD  CONSTRAINT [DF_borrow_borrowTime]  DEFAULT (getdate()) FOR [borrowTime]
GO
/****** Object:  Default [DF_borrow_t_renew]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t] ADD  CONSTRAINT [DF_borrow_t_renew]  DEFAULT ((0)) FOR [renew]
GO
/****** Object:  Default [DF_borrow_giveback]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t] ADD  CONSTRAINT [DF_borrow_giveback]  DEFAULT ((0)) FOR [giveback]
GO
/****** Object:  Default [DF_borrow_givebackOperator]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t] ADD  CONSTRAINT [DF_borrow_givebackOperator]  DEFAULT ((0)) FOR [givebackOperator]
GO
/****** Object:  ForeignKey [FK_reader_t_operator_t]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[reader_t]  WITH NOCHECK ADD  CONSTRAINT [FK_reader_t_operator_t] FOREIGN KEY([operator])
REFERENCES [dbo].[operator_t] ([id])
GO
ALTER TABLE [dbo].[reader_t] CHECK CONSTRAINT [FK_reader_t_operator_t]
GO
/****** Object:  ForeignKey [FK_reader_t_readerType_t]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[reader_t]  WITH NOCHECK ADD  CONSTRAINT [FK_reader_t_readerType_t] FOREIGN KEY([type])
REFERENCES [dbo].[readerType_t] ([id])
GO
ALTER TABLE [dbo].[reader_t] CHECK CONSTRAINT [FK_reader_t_readerType_t]
GO
/****** Object:  ForeignKey [FKCC523FF84A69DB7F]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[reader_t]  WITH CHECK ADD  CONSTRAINT [FKCC523FF84A69DB7F] FOREIGN KEY([type])
REFERENCES [dbo].[readerType_t] ([id])
GO
ALTER TABLE [dbo].[reader_t] CHECK CONSTRAINT [FKCC523FF84A69DB7F]
GO
/****** Object:  ForeignKey [FKCC523FF85BEA3091]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[reader_t]  WITH CHECK ADD  CONSTRAINT [FKCC523FF85BEA3091] FOREIGN KEY([type])
REFERENCES [dbo].[readerType_t] ([id])
GO
ALTER TABLE [dbo].[reader_t] CHECK CONSTRAINT [FKCC523FF85BEA3091]
GO
/****** Object:  ForeignKey [FKCC523FF89A468089]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[reader_t]  WITH CHECK ADD  CONSTRAINT [FKCC523FF89A468089] FOREIGN KEY([operator])
REFERENCES [dbo].[operator_t] ([id])
GO
ALTER TABLE [dbo].[reader_t] CHECK CONSTRAINT [FKCC523FF89A468089]
GO
/****** Object:  ForeignKey [FKCC523FF8C3502E9B]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[reader_t]  WITH CHECK ADD  CONSTRAINT [FKCC523FF8C3502E9B] FOREIGN KEY([operator])
REFERENCES [dbo].[operator_t] ([id])
GO
ALTER TABLE [dbo].[reader_t] CHECK CONSTRAINT [FKCC523FF8C3502E9B]
GO
/****** Object:  ForeignKey [FK_book_t_booktype_t]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[book_t]  WITH CHECK ADD  CONSTRAINT [FK_book_t_booktype_t] FOREIGN KEY([type])
REFERENCES [dbo].[booktype_t] ([id])
GO
ALTER TABLE [dbo].[book_t] CHECK CONSTRAINT [FK_book_t_booktype_t]
GO
/****** Object:  ForeignKey [FK_book_t_operator_t]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[book_t]  WITH CHECK ADD  CONSTRAINT [FK_book_t_operator_t] FOREIGN KEY([operator])
REFERENCES [dbo].[operator_t] ([id])
GO
ALTER TABLE [dbo].[book_t] CHECK CONSTRAINT [FK_book_t_operator_t]
GO
/****** Object:  ForeignKey [FKAD8B309E8F96811]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[book_t]  WITH CHECK ADD  CONSTRAINT [FKAD8B309E8F96811] FOREIGN KEY([type])
REFERENCES [dbo].[booktype_t] ([id])
GO
ALTER TABLE [dbo].[book_t] CHECK CONSTRAINT [FKAD8B309E8F96811]
GO
/****** Object:  ForeignKey [FKAD8B309E9A468089]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[book_t]  WITH CHECK ADD  CONSTRAINT [FKAD8B309E9A468089] FOREIGN KEY([operator])
REFERENCES [dbo].[operator_t] ([id])
GO
ALTER TABLE [dbo].[book_t] CHECK CONSTRAINT [FKAD8B309E9A468089]
GO
/****** Object:  ForeignKey [FKAD8B309EC3502E9B]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[book_t]  WITH CHECK ADD  CONSTRAINT [FKAD8B309EC3502E9B] FOREIGN KEY([operator])
REFERENCES [dbo].[operator_t] ([id])
GO
ALTER TABLE [dbo].[book_t] CHECK CONSTRAINT [FKAD8B309EC3502E9B]
GO
/****** Object:  ForeignKey [FKAD8B309EDFEFB9FF]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[book_t]  WITH CHECK ADD  CONSTRAINT [FKAD8B309EDFEFB9FF] FOREIGN KEY([type])
REFERENCES [dbo].[booktype_t] ([id])
GO
ALTER TABLE [dbo].[book_t] CHECK CONSTRAINT [FKAD8B309EDFEFB9FF]
GO
/****** Object:  ForeignKey [FK_barcode_t_book_t]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[barcode_t]  WITH NOCHECK ADD  CONSTRAINT [FK_barcode_t_book_t] FOREIGN KEY([bookid])
REFERENCES [dbo].[book_t] ([id])
GO
ALTER TABLE [dbo].[barcode_t] CHECK CONSTRAINT [FK_barcode_t_book_t]
GO
/****** Object:  ForeignKey [FK5C45D47560D8D8C9]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[barcode_t]  WITH NOCHECK ADD  CONSTRAINT [FK5C45D47560D8D8C9] FOREIGN KEY([bookid])
REFERENCES [dbo].[book_t] ([id])
GO
ALTER TABLE [dbo].[barcode_t] CHECK CONSTRAINT [FK5C45D47560D8D8C9]
GO
/****** Object:  ForeignKey [FK5C45D47564F2B8DB]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[barcode_t]  WITH CHECK ADD  CONSTRAINT [FK5C45D47564F2B8DB] FOREIGN KEY([bookid])
REFERENCES [dbo].[book_t] ([id])
GO
ALTER TABLE [dbo].[barcode_t] CHECK CONSTRAINT [FK5C45D47564F2B8DB]
GO
/****** Object:  ForeignKey [FK_borrow_t_barcode_t]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t]  WITH NOCHECK ADD  CONSTRAINT [FK_borrow_t_barcode_t] FOREIGN KEY([bookid])
REFERENCES [dbo].[barcode_t] ([id])
GO
ALTER TABLE [dbo].[borrow_t] CHECK CONSTRAINT [FK_borrow_t_barcode_t]
GO
/****** Object:  ForeignKey [FK_borrow_t_operator_t]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t]  WITH NOCHECK ADD  CONSTRAINT [FK_borrow_t_operator_t] FOREIGN KEY([borrowOperator])
REFERENCES [dbo].[operator_t] ([id])
GO
ALTER TABLE [dbo].[borrow_t] CHECK CONSTRAINT [FK_borrow_t_operator_t]
GO
/****** Object:  ForeignKey [FK_borrow_t_operator_t1]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t]  WITH NOCHECK ADD  CONSTRAINT [FK_borrow_t_operator_t1] FOREIGN KEY([givebackOperator])
REFERENCES [dbo].[operator_t] ([id])
GO
ALTER TABLE [dbo].[borrow_t] CHECK CONSTRAINT [FK_borrow_t_operator_t1]
GO
/****** Object:  ForeignKey [FK_borrow_t_reader_t]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t]  WITH NOCHECK ADD  CONSTRAINT [FK_borrow_t_reader_t] FOREIGN KEY([readerid])
REFERENCES [dbo].[reader_t] ([id])
GO
ALTER TABLE [dbo].[borrow_t] CHECK CONSTRAINT [FK_borrow_t_reader_t]
GO
/****** Object:  ForeignKey [FK7D0A0CAA37A21390]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t]  WITH CHECK ADD  CONSTRAINT [FK7D0A0CAA37A21390] FOREIGN KEY([borrowOperator])
REFERENCES [dbo].[operator_t] ([id])
GO
ALTER TABLE [dbo].[borrow_t] CHECK CONSTRAINT [FK7D0A0CAA37A21390]
GO
/****** Object:  ForeignKey [FK7D0A0CAA3A8C0801]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t]  WITH CHECK ADD  CONSTRAINT [FK7D0A0CAA3A8C0801] FOREIGN KEY([givebackOperator])
REFERENCES [dbo].[operator_t] ([id])
GO
ALTER TABLE [dbo].[borrow_t] CHECK CONSTRAINT [FK7D0A0CAA3A8C0801]
GO
/****** Object:  ForeignKey [FK7D0A0CAA6395B613]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t]  WITH CHECK ADD  CONSTRAINT [FK7D0A0CAA6395B613] FOREIGN KEY([givebackOperator])
REFERENCES [dbo].[operator_t] ([id])
GO
ALTER TABLE [dbo].[borrow_t] CHECK CONSTRAINT [FK7D0A0CAA6395B613]
GO
/****** Object:  ForeignKey [FK7D0A0CAA65723535]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t]  WITH CHECK ADD  CONSTRAINT [FK7D0A0CAA65723535] FOREIGN KEY([readerid])
REFERENCES [dbo].[reader_t] ([id])
GO
ALTER TABLE [dbo].[borrow_t] CHECK CONSTRAINT [FK7D0A0CAA65723535]
GO
/****** Object:  ForeignKey [FK7D0A0CAAA191181F]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t]  WITH CHECK ADD  CONSTRAINT [FK7D0A0CAAA191181F] FOREIGN KEY([bookid])
REFERENCES [dbo].[barcode_t] ([id])
GO
ALTER TABLE [dbo].[borrow_t] CHECK CONSTRAINT [FK7D0A0CAAA191181F]
GO
/****** Object:  ForeignKey [FK7D0A0CAAA82F0D8D]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t]  WITH NOCHECK ADD  CONSTRAINT [FK7D0A0CAAA82F0D8D] FOREIGN KEY([bookid])
REFERENCES [dbo].[barcode_t] ([id])
GO
ALTER TABLE [dbo].[borrow_t] CHECK CONSTRAINT [FK7D0A0CAAA82F0D8D]
GO
/****** Object:  ForeignKey [FK7D0A0CAAC04AAE23]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t]  WITH CHECK ADD  CONSTRAINT [FK7D0A0CAAC04AAE23] FOREIGN KEY([readerid])
REFERENCES [dbo].[reader_t] ([id])
GO
ALTER TABLE [dbo].[borrow_t] CHECK CONSTRAINT [FK7D0A0CAAC04AAE23]
GO
/****** Object:  ForeignKey [FK7D0A0CAAE98657E]    Script Date: 06/15/2010 16:24:28 ******/
ALTER TABLE [dbo].[borrow_t]  WITH CHECK ADD  CONSTRAINT [FK7D0A0CAAE98657E] FOREIGN KEY([borrowOperator])
REFERENCES [dbo].[operator_t] ([id])
GO
ALTER TABLE [dbo].[borrow_t] CHECK CONSTRAINT [FK7D0A0CAAE98657E]
GO
