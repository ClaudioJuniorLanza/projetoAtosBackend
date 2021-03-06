USE [master]
GO
/****** Object:  Database [springbootdb]    Script Date: 27/12/2018 15:55:49 ******/
CREATE DATABASE [springbootdb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'springbootdb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\springbootdb.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'springbootdb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\springbootdb_log.ldf' , SIZE = 1072KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [springbootdb] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [springbootdb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [springbootdb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [springbootdb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [springbootdb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [springbootdb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [springbootdb] SET ARITHABORT OFF 
GO
ALTER DATABASE [springbootdb] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [springbootdb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [springbootdb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [springbootdb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [springbootdb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [springbootdb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [springbootdb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [springbootdb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [springbootdb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [springbootdb] SET  ENABLE_BROKER 
GO
ALTER DATABASE [springbootdb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [springbootdb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [springbootdb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [springbootdb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [springbootdb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [springbootdb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [springbootdb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [springbootdb] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [springbootdb] SET  MULTI_USER 
GO
ALTER DATABASE [springbootdb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [springbootdb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [springbootdb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [springbootdb] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [springbootdb] SET DELAYED_DURABILITY = DISABLED 
GO
USE [springbootdb]
GO
/****** Object:  Table [dbo].[certification]    Script Date: 27/12/2018 15:55:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[certification](
	[id_certification] [int] IDENTITY(1,1) NOT NULL,
	[descricao] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_certification] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[employee]    Script Date: 27/12/2018 15:55:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[employee](
	[id_employee] [int] IDENTITY(1,1) NOT NULL,
	[gcm] [int] NOT NULL,
	[manager] [varchar](120) NOT NULL,
	[name] [varchar](120) NOT NULL,
	[role] [varchar](100) NOT NULL,
	[salary] [float] NOT NULL,
	[project_id_project] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_employee] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[employee_certification]    Script Date: 27/12/2018 15:55:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[employee_certification](
	[id_employee] [int] NOT NULL,
	[id_certification] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_employee] ASC,
	[id_certification] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[employee_skill]    Script Date: 27/12/2018 15:55:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[employee_skill](
	[id_skill] [int] NOT NULL,
	[id_employee] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_skill] ASC,
	[id_employee] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[projects]    Script Date: 27/12/2018 15:55:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[projects](
	[id_project] [int] IDENTITY(1,1) NOT NULL,
	[customer] [varchar](100) NULL,
	[dt_begin] [datetime2](7) NULL,
	[dt_end] [datetime2](7) NULL,
	[name] [varchar](150) NULL,
	[value_of_project] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_project] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[skill]    Script Date: 27/12/2018 15:55:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[skill](
	[id_skill] [int] IDENTITY(1,1) NOT NULL,
	[descricao] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_skill] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[employee]  WITH CHECK ADD  CONSTRAINT [FKs5cr49form7gu7pcvtimle46i] FOREIGN KEY([project_id_project])
REFERENCES [dbo].[projects] ([id_project])
GO
ALTER TABLE [dbo].[employee] CHECK CONSTRAINT [FKs5cr49form7gu7pcvtimle46i]
GO
ALTER TABLE [dbo].[employee_certification]  WITH CHECK ADD  CONSTRAINT [FK5mdf62dcimco7ahp2u6vri2ni] FOREIGN KEY([id_employee])
REFERENCES [dbo].[employee] ([id_employee])
GO
ALTER TABLE [dbo].[employee_certification] CHECK CONSTRAINT [FK5mdf62dcimco7ahp2u6vri2ni]
GO
ALTER TABLE [dbo].[employee_certification]  WITH CHECK ADD  CONSTRAINT [FKsd96u2y7sysk74s688p2rqbvl] FOREIGN KEY([id_certification])
REFERENCES [dbo].[certification] ([id_certification])
GO
ALTER TABLE [dbo].[employee_certification] CHECK CONSTRAINT [FKsd96u2y7sysk74s688p2rqbvl]
GO
ALTER TABLE [dbo].[employee_skill]  WITH CHECK ADD  CONSTRAINT [FKcjf3nb0pnsvueit127g1kb10] FOREIGN KEY([id_employee])
REFERENCES [dbo].[employee] ([id_employee])
GO
ALTER TABLE [dbo].[employee_skill] CHECK CONSTRAINT [FKcjf3nb0pnsvueit127g1kb10]
GO
ALTER TABLE [dbo].[employee_skill]  WITH CHECK ADD  CONSTRAINT [FKcui0o4twv54p2uonnd7ta5gx5] FOREIGN KEY([id_skill])
REFERENCES [dbo].[skill] ([id_skill])
GO
ALTER TABLE [dbo].[employee_skill] CHECK CONSTRAINT [FKcui0o4twv54p2uonnd7ta5gx5]
GO
USE [master]
GO
ALTER DATABASE [springbootdb] SET  READ_WRITE 
GO
