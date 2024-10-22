USE [master]
GO
/****** Object:  Database [EnaCristina]    Script Date: 2/04/2024 15:09:12 ******/
CREATE DATABASE [EnaCristina]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'EnaCristina', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQL2022\MSSQL\DATA\EnaCristina.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'EnaCristina_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQL2022\MSSQL\DATA\EnaCristina_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [EnaCristina] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [EnaCristina].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [EnaCristina] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [EnaCristina] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [EnaCristina] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [EnaCristina] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [EnaCristina] SET ARITHABORT OFF 
GO
ALTER DATABASE [EnaCristina] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [EnaCristina] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [EnaCristina] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [EnaCristina] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [EnaCristina] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [EnaCristina] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [EnaCristina] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [EnaCristina] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [EnaCristina] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [EnaCristina] SET  ENABLE_BROKER 
GO
ALTER DATABASE [EnaCristina] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [EnaCristina] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [EnaCristina] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [EnaCristina] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [EnaCristina] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [EnaCristina] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [EnaCristina] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [EnaCristina] SET RECOVERY FULL 
GO
ALTER DATABASE [EnaCristina] SET  MULTI_USER 
GO
ALTER DATABASE [EnaCristina] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [EnaCristina] SET DB_CHAINING OFF 
GO
ALTER DATABASE [EnaCristina] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [EnaCristina] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [EnaCristina] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [EnaCristina] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'EnaCristina', N'ON'
GO
ALTER DATABASE [EnaCristina] SET QUERY_STORE = ON
GO
ALTER DATABASE [EnaCristina] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [EnaCristina]
GO
/****** Object:  User [userBus]    Script Date: 2/04/2024 15:09:12 ******/
CREATE USER [userBus] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Schema [ctgerente]    Script Date: 2/04/2024 15:09:12 ******/
CREATE SCHEMA [ctgerente]
GO
/****** Object:  Schema [ctventas]    Script Date: 2/04/2024 15:09:12 ******/
CREATE SCHEMA [ctventas]
GO
/****** Object:  Table [dbo].[categoria]    Script Date: 2/04/2024 15:09:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categoria](
	[id_categoria] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](40) NOT NULL,
	[descripcion] [nvarchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_categoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[clientes]    Script Date: 2/04/2024 15:09:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[clientes](
	[id_cliente] [int] IDENTITY(1,1) NOT NULL,
	[nombres] [nvarchar](50) NOT NULL,
	[apellido_paterno] [nvarchar](30) NOT NULL,
	[apellido_materno] [nvarchar](30) NOT NULL,
	[dni] [nvarchar](9) NOT NULL,
	[ruc] [nvarchar](11) NULL,
	[direccion] [nvarchar](60) NULL,
	[correo] [nvarchar](60) NULL,
	[telefono] [nvarchar](13) NOT NULL,
	[sexo] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_cliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[detalle_venta]    Script Date: 2/04/2024 15:09:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detalle_venta](
	[id_detalle] [int] IDENTITY(1,1) NOT NULL,
	[id_producto] [int] NOT NULL,
	[id_venta] [int] NOT NULL,
	[precio_unitario] [decimal](10, 2) NOT NULL,
	[sub_total] [decimal](10, 2) NOT NULL,
	[cantidad] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_detalle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[empleados]    Script Date: 2/04/2024 15:09:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[empleados](
	[id_empleado] [int] IDENTITY(1,1) NOT NULL,
	[nombres] [nvarchar](50) NOT NULL,
	[apellido_parterno] [nvarchar](20) NULL,
	[apellido_materno] [nvarchar](20) NULL,
	[dni] [nvarchar](9) NULL,
	[numero_telefono] [nvarchar](13) NULL,
	[id_usuario] [int] NOT NULL,
	[sexo] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_empleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[factura]    Script Date: 2/04/2024 15:09:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[factura](
	[id_factura] [int] IDENTITY(1,1) NOT NULL,
	[fecha_factura] [date] NULL,
	[id_cliente] [int] NULL,
	[total_factura] [decimal](10, 2) NULL,
	[estado] [varchar](20) NULL,
	[id_metodo] [int] NOT NULL,
	[descuento] [decimal](5, 2) NULL,
	[impuestos] [decimal](5, 2) NULL,
	[id_venta] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_factura] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[inventario]    Script Date: 2/04/2024 15:09:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[inventario](
	[id_producto] [int] NOT NULL,
	[codigo_barras] [nvarchar](25) NOT NULL,
	[cantidad_stock] [int] NOT NULL,
	[id_proveedor] [int] NULL,
	[fecha_adquisicion] [date] NOT NULL,
	[nivel_rebastecimiento] [int] NULL,
	[nota] [text] NULL,
 CONSTRAINT [PK_inventario] PRIMARY KEY CLUSTERED 
(
	[id_producto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[metodo_pago]    Script Date: 2/04/2024 15:09:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[metodo_pago](
	[id_metodo] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_metodo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[productos]    Script Date: 2/04/2024 15:09:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[productos](
	[id_producto] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[descripcion] [nvarchar](60) NOT NULL,
	[precio] [decimal](10, 2) NOT NULL,
	[costo] [decimal](10, 2) NOT NULL,
	[existencia] [int] NOT NULL,
	[id_categoria] [int] NOT NULL,
	[igv_iva] [decimal](10, 2) NULL,
	[precio_sub] [decimal](10, 2) NULL,
 CONSTRAINT [PK_productos] PRIMARY KEY CLUSTERED 
(
	[id_producto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[proveedores]    Script Date: 2/04/2024 15:09:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[proveedores](
	[id_proveedor] [int] IDENTITY(1,1) NOT NULL,
	[nombre_compania] [nvarchar](40) NOT NULL,
	[nombre_contacto] [nvarchar](50) NOT NULL,
	[cargo_contacto] [nvarchar](30) NULL,
	[direccion] [nvarchar](60) NULL,
	[ciudad] [nvarchar](20) NOT NULL,
	[region] [nvarchar](20) NOT NULL,
	[codigo_postal] [nvarchar](15) NOT NULL,
	[pais] [nvarchar](35) NOT NULL,
	[telefono] [nvarchar](15) NOT NULL,
	[fax] [nvarchar](60) NULL,
	[pagina_principal] [nvarchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_proveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[usuarios]    Script Date: 2/04/2024 15:09:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[usuarios](
	[id_usuario] [int] IDENTITY(1,1) NOT NULL,
	[usuario] [nvarchar](20) NOT NULL,
	[clave] [nvarchar](25) NOT NULL,
	[cargo] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_usuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[venta]    Script Date: 2/04/2024 15:09:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[venta](
	[id_venta] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[total] [decimal](10, 2) NOT NULL,
	[id_cliente] [int] NOT NULL,
	[id_empleado] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_venta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[categoria] ON 

INSERT [dbo].[categoria] ([id_categoria], [nombre], [descripcion]) VALUES (2, N'Tuberías', N'Todos referente a tubos')
INSERT [dbo].[categoria] ([id_categoria], [nombre], [descripcion]) VALUES (6, N'Cemento', N'Todo referente a cemento')
SET IDENTITY_INSERT [dbo].[categoria] OFF
GO
SET IDENTITY_INSERT [dbo].[clientes] ON 

INSERT [dbo].[clientes] ([id_cliente], [nombres], [apellido_paterno], [apellido_materno], [dni], [ruc], [direccion], [correo], [telefono], [sexo]) VALUES (1, N'Luis Fernando', N'Zapata', N'Saavedra', N'287382', N'53151555', N'Nueva Direccion', N'correo@correo.co', N'43322', N'Hombre')
SET IDENTITY_INSERT [dbo].[clientes] OFF
GO
SET IDENTITY_INSERT [dbo].[detalle_venta] ON 

INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (59, 11, 26, CAST(789.99 AS Decimal(10, 2)), CAST(1943.37 AS Decimal(10, 2)), 3)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (60, 11, 27, CAST(789.99 AS Decimal(10, 2)), CAST(1943.37 AS Decimal(10, 2)), 3)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (61, 11, 28, CAST(789.99 AS Decimal(10, 2)), CAST(647.79 AS Decimal(10, 2)), 1)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (62, 11, 29, CAST(789.99 AS Decimal(10, 2)), CAST(1943.37 AS Decimal(10, 2)), 3)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (63, 6, 29, CAST(239.99 AS Decimal(10, 2)), CAST(393.58 AS Decimal(10, 2)), 2)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (64, 11, 30, CAST(789.99 AS Decimal(10, 2)), CAST(1295.58 AS Decimal(10, 2)), 2)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (65, 11, 31, CAST(789.99 AS Decimal(10, 2)), CAST(1943.37 AS Decimal(10, 2)), 3)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (66, 11, 32, CAST(789.99 AS Decimal(10, 2)), CAST(1295.58 AS Decimal(10, 2)), 2)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (67, 6, 32, CAST(239.99 AS Decimal(10, 2)), CAST(787.16 AS Decimal(10, 2)), 4)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (68, 6, 33, CAST(239.99 AS Decimal(10, 2)), CAST(196.79 AS Decimal(10, 2)), 1)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (69, 11, 33, CAST(789.99 AS Decimal(10, 2)), CAST(1943.37 AS Decimal(10, 2)), 3)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (70, 11, 34, CAST(789.99 AS Decimal(10, 2)), CAST(1943.37 AS Decimal(10, 2)), 3)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (71, 6, 34, CAST(239.99 AS Decimal(10, 2)), CAST(787.16 AS Decimal(10, 2)), 4)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (72, 6, 35, CAST(239.99 AS Decimal(10, 2)), CAST(590.37 AS Decimal(10, 2)), 3)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (73, 11, 35, CAST(789.99 AS Decimal(10, 2)), CAST(3238.95 AS Decimal(10, 2)), 5)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (74, 11, 36, CAST(789.99 AS Decimal(10, 2)), CAST(3886.74 AS Decimal(10, 2)), 6)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (75, 6, 36, CAST(239.99 AS Decimal(10, 2)), CAST(2164.69 AS Decimal(10, 2)), 11)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (76, 11, 37, CAST(789.99 AS Decimal(10, 2)), CAST(3886.74 AS Decimal(10, 2)), 6)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (77, 6, 37, CAST(239.99 AS Decimal(10, 2)), CAST(2164.69 AS Decimal(10, 2)), 11)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (78, 11, 38, CAST(789.99 AS Decimal(10, 2)), CAST(647.79 AS Decimal(10, 2)), 2)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (79, 6, 38, CAST(239.99 AS Decimal(10, 2)), CAST(196.79 AS Decimal(10, 2)), 3)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (80, 6, 39, CAST(239.99 AS Decimal(10, 2)), CAST(196.79 AS Decimal(10, 2)), 3)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (81, 11, 39, CAST(789.99 AS Decimal(10, 2)), CAST(647.79 AS Decimal(10, 2)), 6)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (82, 11, 40, CAST(789.99 AS Decimal(10, 2)), CAST(647.79 AS Decimal(10, 2)), 2)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (83, 6, 40, CAST(239.99 AS Decimal(10, 2)), CAST(196.79 AS Decimal(10, 2)), 4)
INSERT [dbo].[detalle_venta] ([id_detalle], [id_producto], [id_venta], [precio_unitario], [sub_total], [cantidad]) VALUES (84, 11, 41, CAST(789.99 AS Decimal(10, 2)), CAST(647.79 AS Decimal(10, 2)), 5)
SET IDENTITY_INSERT [dbo].[detalle_venta] OFF
GO
SET IDENTITY_INSERT [dbo].[empleados] ON 

INSERT [dbo].[empleados] ([id_empleado], [nombres], [apellido_parterno], [apellido_materno], [dni], [numero_telefono], [id_usuario], [sexo]) VALUES (1, N' Keyla', N'A', N'B', N'3726352', N'987654321', 2, N'Mujer')
INSERT [dbo].[empleados] ([id_empleado], [nombres], [apellido_parterno], [apellido_materno], [dni], [numero_telefono], [id_usuario], [sexo]) VALUES (2, N'Daniela', N'A', N'B', N'12345678', N'987654321', 1, N'Mujer')
SET IDENTITY_INSERT [dbo].[empleados] OFF
GO
SET IDENTITY_INSERT [dbo].[factura] ON 

INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (7, CAST(N'2024-01-02' AS Date), 1, CAST(2369.97 AS Decimal(10, 2)), N'pagado', 3, CAST(0.00 AS Decimal(5, 2)), CAST(426.60 AS Decimal(5, 2)), 26)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (8, CAST(N'2024-01-02' AS Date), 1, CAST(2369.97 AS Decimal(10, 2)), N'pagado', 4, CAST(0.00 AS Decimal(5, 2)), CAST(426.60 AS Decimal(5, 2)), 27)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (9, CAST(N'2024-01-02' AS Date), 1, CAST(789.99 AS Decimal(10, 2)), N'pagado', 4, CAST(0.00 AS Decimal(5, 2)), CAST(142.20 AS Decimal(5, 2)), 28)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (10, CAST(N'2024-01-02' AS Date), 1, CAST(2849.95 AS Decimal(10, 2)), N'pagado', 6, CAST(0.00 AS Decimal(5, 2)), CAST(513.00 AS Decimal(5, 2)), 29)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (11, CAST(N'2024-01-02' AS Date), 1, CAST(2849.95 AS Decimal(10, 2)), N'pagado', 6, CAST(0.00 AS Decimal(5, 2)), CAST(513.00 AS Decimal(5, 2)), 29)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (12, CAST(N'2024-01-02' AS Date), 1, CAST(1579.98 AS Decimal(10, 2)), N'pagado', 3, CAST(0.00 AS Decimal(5, 2)), CAST(284.40 AS Decimal(5, 2)), 30)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (13, CAST(N'2024-01-02' AS Date), 1, CAST(2369.97 AS Decimal(10, 2)), N'pagado', 4, CAST(0.00 AS Decimal(5, 2)), CAST(426.60 AS Decimal(5, 2)), 31)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (14, CAST(N'2024-01-02' AS Date), 1, CAST(2539.94 AS Decimal(10, 2)), N'pagado', 6, CAST(0.00 AS Decimal(5, 2)), CAST(457.20 AS Decimal(5, 2)), 32)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (15, CAST(N'2024-01-02' AS Date), 1, CAST(2539.94 AS Decimal(10, 2)), N'pagado', 6, CAST(0.00 AS Decimal(5, 2)), CAST(457.20 AS Decimal(5, 2)), 32)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (16, CAST(N'2024-01-02' AS Date), 1, CAST(2609.96 AS Decimal(10, 2)), N'pagado', 6, CAST(0.00 AS Decimal(5, 2)), CAST(469.80 AS Decimal(5, 2)), 33)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (17, CAST(N'2024-01-02' AS Date), 1, CAST(2609.96 AS Decimal(10, 2)), N'pagado', 6, CAST(0.00 AS Decimal(5, 2)), CAST(469.80 AS Decimal(5, 2)), 33)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (18, CAST(N'2024-01-02' AS Date), 1, CAST(3329.93 AS Decimal(10, 2)), N'pagado', 6, CAST(0.00 AS Decimal(5, 2)), CAST(599.40 AS Decimal(5, 2)), 34)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (19, CAST(N'2024-01-02' AS Date), 1, CAST(3329.93 AS Decimal(10, 2)), N'pagado', 6, CAST(0.00 AS Decimal(5, 2)), CAST(599.40 AS Decimal(5, 2)), 34)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (20, CAST(N'2024-01-02' AS Date), 1, CAST(4669.92 AS Decimal(10, 2)), N'pagado', 3, CAST(0.00 AS Decimal(5, 2)), CAST(840.60 AS Decimal(5, 2)), 35)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (21, CAST(N'2024-01-02' AS Date), 1, CAST(4669.92 AS Decimal(10, 2)), N'pagado', 3, CAST(0.00 AS Decimal(5, 2)), CAST(840.60 AS Decimal(5, 2)), 35)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (26, CAST(N'2024-02-11' AS Date), 1, CAST(1029.98 AS Decimal(10, 2)), N'pagado', 4, CAST(0.00 AS Decimal(5, 2)), CAST(185.40 AS Decimal(5, 2)), 38)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (27, CAST(N'2024-02-11' AS Date), 1, CAST(1029.98 AS Decimal(10, 2)), N'pagado', 4, CAST(0.00 AS Decimal(5, 2)), CAST(185.40 AS Decimal(5, 2)), 38)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (28, CAST(N'2024-02-11' AS Date), 1, CAST(1029.98 AS Decimal(10, 2)), N'pagado', 6, CAST(0.00 AS Decimal(5, 2)), CAST(185.40 AS Decimal(5, 2)), 39)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (29, CAST(N'2024-02-11' AS Date), 1, CAST(1029.98 AS Decimal(10, 2)), N'pagado', 6, CAST(0.00 AS Decimal(5, 2)), CAST(185.40 AS Decimal(5, 2)), 39)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (30, CAST(N'2024-02-11' AS Date), 1, CAST(1029.98 AS Decimal(10, 2)), N'pagado', 5, CAST(0.00 AS Decimal(5, 2)), CAST(185.40 AS Decimal(5, 2)), 40)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (31, CAST(N'2024-02-11' AS Date), 1, CAST(1029.98 AS Decimal(10, 2)), N'pagado', 5, CAST(0.00 AS Decimal(5, 2)), CAST(185.40 AS Decimal(5, 2)), 40)
INSERT [dbo].[factura] ([id_factura], [fecha_factura], [id_cliente], [total_factura], [estado], [id_metodo], [descuento], [impuestos], [id_venta]) VALUES (32, CAST(N'2024-04-02' AS Date), 1, CAST(789.99 AS Decimal(10, 2)), N'pagado', 6, CAST(0.00 AS Decimal(5, 2)), CAST(142.20 AS Decimal(5, 2)), 41)
SET IDENTITY_INSERT [dbo].[factura] OFF
GO
INSERT [dbo].[inventario] ([id_producto], [codigo_barras], [cantidad_stock], [id_proveedor], [fecha_adquisicion], [nivel_rebastecimiento], [nota]) VALUES (6, N'237357333', 8, 3, CAST(N'2023-12-15' AS Date), 4, N'Se adquirido en navidad')
INSERT [dbo].[inventario] ([id_producto], [codigo_barras], [cantidad_stock], [id_proveedor], [fecha_adquisicion], [nivel_rebastecimiento], [nota]) VALUES (11, N'237357333', 8, 3, CAST(N'2023-12-15' AS Date), 4, N'Se adquirido en navidad')
GO
SET IDENTITY_INSERT [dbo].[metodo_pago] ON 

INSERT [dbo].[metodo_pago] ([id_metodo], [nombre]) VALUES (6, N'Contado')
INSERT [dbo].[metodo_pago] ([id_metodo], [nombre]) VALUES (5, N'Plin')
INSERT [dbo].[metodo_pago] ([id_metodo], [nombre]) VALUES (3, N'Tarjeta de Crédito')
INSERT [dbo].[metodo_pago] ([id_metodo], [nombre]) VALUES (4, N'Tarjeta de Débito')
INSERT [dbo].[metodo_pago] ([id_metodo], [nombre]) VALUES (1, N'Yape')
SET IDENTITY_INSERT [dbo].[metodo_pago] OFF
GO
SET IDENTITY_INSERT [dbo].[productos] ON 

INSERT [dbo].[productos] ([id_producto], [nombre], [descripcion], [precio], [costo], [existencia], [id_categoria], [igv_iva], [precio_sub]) VALUES (6, N'Taladro Percutor Crown 1/2', N'1/2" 810W', CAST(239.99 AS Decimal(10, 2)), CAST(209.99 AS Decimal(10, 2)), 8, 6, CAST(43.20 AS Decimal(10, 2)), CAST(196.79 AS Decimal(10, 2)))
INSERT [dbo].[productos] ([id_producto], [nombre], [descripcion], [precio], [costo], [existencia], [id_categoria], [igv_iva], [precio_sub]) VALUES (11, N'Atornillador Inalambrico con Percutor Crown', N'4Amp + 2 baterías', CAST(789.99 AS Decimal(10, 2)), CAST(749.93 AS Decimal(10, 2)), 8, 2, CAST(142.20 AS Decimal(10, 2)), CAST(647.79 AS Decimal(10, 2)))
SET IDENTITY_INSERT [dbo].[productos] OFF
GO
SET IDENTITY_INSERT [dbo].[proveedores] ON 

INSERT [dbo].[proveedores] ([id_proveedor], [nombre_compania], [nombre_contacto], [cargo_contacto], [direccion], [ciudad], [region], [codigo_postal], [pais], [telefono], [fax], [pagina_principal]) VALUES (3, N'Cemento SAC', N'Juan', N'Despachador', N'Nueva esperanza', N'Piura', N'Piura', N'20221', N'Perú', N'98765223', N'20221', N'www.Cemento.com')
INSERT [dbo].[proveedores] ([id_proveedor], [nombre_compania], [nombre_contacto], [cargo_contacto], [direccion], [ciudad], [region], [codigo_postal], [pais], [telefono], [fax], [pagina_principal]) VALUES (4, N'Tubería SAC', N'Luis', N'Jefe de empresa', N'Av.Chulucanas Mz.C Lt.12 Los Jardines', N'Lima', N'Pueblo Libre', N'20009', N'Perú', N'987654321', N'23232', N'www.tuberia.com')
SET IDENTITY_INSERT [dbo].[proveedores] OFF
GO
SET IDENTITY_INSERT [dbo].[usuarios] ON 

INSERT [dbo].[usuarios] ([id_usuario], [usuario], [clave], [cargo]) VALUES (1, N'Keyla', N'12345', N'Ventas')
INSERT [dbo].[usuarios] ([id_usuario], [usuario], [clave], [cargo]) VALUES (2, N'Daniela', N'12345', N'Ventas')
INSERT [dbo].[usuarios] ([id_usuario], [usuario], [clave], [cargo]) VALUES (6, N'admin', N'12345', N'Gerente')
SET IDENTITY_INSERT [dbo].[usuarios] OFF
GO
SET IDENTITY_INSERT [dbo].[venta] ON 

INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (26, CAST(N'2024-01-02' AS Date), CAST(2369.97 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (27, CAST(N'2024-01-02' AS Date), CAST(2369.97 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (28, CAST(N'2024-01-02' AS Date), CAST(789.99 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (29, CAST(N'2024-01-02' AS Date), CAST(2849.95 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (30, CAST(N'2024-01-02' AS Date), CAST(1579.98 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (31, CAST(N'2024-01-02' AS Date), CAST(2369.97 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (32, CAST(N'2024-01-02' AS Date), CAST(2539.94 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (33, CAST(N'2024-01-02' AS Date), CAST(2609.96 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (34, CAST(N'2024-01-02' AS Date), CAST(3329.93 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (35, CAST(N'2024-01-02' AS Date), CAST(4669.92 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (36, CAST(N'2024-01-02' AS Date), CAST(7379.83 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (37, CAST(N'2024-01-02' AS Date), CAST(7379.83 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (38, CAST(N'2024-02-11' AS Date), CAST(1029.98 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (39, CAST(N'2024-02-11' AS Date), CAST(1029.98 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (40, CAST(N'2024-02-11' AS Date), CAST(1029.98 AS Decimal(10, 2)), 1, -1)
INSERT [dbo].[venta] ([id_venta], [fecha], [total], [id_cliente], [id_empleado]) VALUES (41, CAST(N'2024-04-02' AS Date), CAST(789.99 AS Decimal(10, 2)), 1, -1)
SET IDENTITY_INSERT [dbo].[venta] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__categori__72AFBCC69867EC55]    Script Date: 2/04/2024 15:09:13 ******/
ALTER TABLE [dbo].[categoria] ADD UNIQUE NONCLUSTERED 
(
	[nombre] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__clientes__D87608A741B5F2E5]    Script Date: 2/04/2024 15:09:13 ******/
ALTER TABLE [dbo].[clientes] ADD UNIQUE NONCLUSTERED 
(
	[dni] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__metodo_p__72AFBCC669799DCE]    Script Date: 2/04/2024 15:09:13 ******/
ALTER TABLE [dbo].[metodo_pago] ADD UNIQUE NONCLUSTERED 
(
	[nombre] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__producto__72AFBCC6B853ACB4]    Script Date: 2/04/2024 15:09:13 ******/
ALTER TABLE [dbo].[productos] ADD UNIQUE NONCLUSTERED 
(
	[nombre] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__proveedo__0DCDE03B5397E4DB]    Script Date: 2/04/2024 15:09:13 ******/
ALTER TABLE [dbo].[proveedores] ADD UNIQUE NONCLUSTERED 
(
	[nombre_compania] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__usuarios__9AFF8FC694EA9AB2]    Script Date: 2/04/2024 15:09:13 ******/
ALTER TABLE [dbo].[usuarios] ADD UNIQUE NONCLUSTERED 
(
	[usuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[detalle_venta]  WITH NOCHECK ADD  CONSTRAINT [FK_detalle_venta_productos] FOREIGN KEY([id_producto])
REFERENCES [dbo].[productos] ([id_producto])
GO
ALTER TABLE [dbo].[detalle_venta] NOCHECK CONSTRAINT [FK_detalle_venta_productos]
GO
ALTER TABLE [dbo].[detalle_venta]  WITH NOCHECK ADD  CONSTRAINT [FK_detalle_venta_venta] FOREIGN KEY([id_venta])
REFERENCES [dbo].[venta] ([id_venta])
GO
ALTER TABLE [dbo].[detalle_venta] NOCHECK CONSTRAINT [FK_detalle_venta_venta]
GO
ALTER TABLE [dbo].[empleados]  WITH NOCHECK ADD  CONSTRAINT [FK_Empleados_usuarios] FOREIGN KEY([id_usuario])
REFERENCES [dbo].[usuarios] ([id_usuario])
GO
ALTER TABLE [dbo].[empleados] CHECK CONSTRAINT [FK_Empleados_usuarios]
GO
ALTER TABLE [dbo].[factura]  WITH NOCHECK ADD  CONSTRAINT [FK_factura_metodo_pago] FOREIGN KEY([id_metodo])
REFERENCES [dbo].[metodo_pago] ([id_metodo])
GO
ALTER TABLE [dbo].[factura] CHECK CONSTRAINT [FK_factura_metodo_pago]
GO
ALTER TABLE [dbo].[factura]  WITH NOCHECK ADD  CONSTRAINT [FK_factura_venta] FOREIGN KEY([id_venta])
REFERENCES [dbo].[venta] ([id_venta])
GO
ALTER TABLE [dbo].[factura] NOCHECK CONSTRAINT [FK_factura_venta]
GO
ALTER TABLE [dbo].[inventario]  WITH CHECK ADD  CONSTRAINT [FK__inventario__productos] FOREIGN KEY([id_producto])
REFERENCES [dbo].[productos] ([id_producto])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[inventario] CHECK CONSTRAINT [FK__inventario__productos]
GO
ALTER TABLE [dbo].[inventario]  WITH NOCHECK ADD  CONSTRAINT [FK_inventario_proveedores] FOREIGN KEY([id_proveedor])
REFERENCES [dbo].[proveedores] ([id_proveedor])
GO
ALTER TABLE [dbo].[inventario] NOCHECK CONSTRAINT [FK_inventario_proveedores]
GO
ALTER TABLE [dbo].[productos]  WITH NOCHECK ADD  CONSTRAINT [FK_productos_categoria] FOREIGN KEY([id_categoria])
REFERENCES [dbo].[categoria] ([id_categoria])
GO
ALTER TABLE [dbo].[productos] NOCHECK CONSTRAINT [FK_productos_categoria]
GO
ALTER TABLE [dbo].[venta]  WITH NOCHECK ADD  CONSTRAINT [FK_venta_clientes] FOREIGN KEY([id_cliente])
REFERENCES [dbo].[clientes] ([id_cliente])
GO
ALTER TABLE [dbo].[venta] NOCHECK CONSTRAINT [FK_venta_clientes]
GO
ALTER TABLE [dbo].[venta]  WITH NOCHECK ADD  CONSTRAINT [FK_venta_Empleados] FOREIGN KEY([id_empleado])
REFERENCES [dbo].[empleados] ([id_empleado])
GO
ALTER TABLE [dbo].[venta] NOCHECK CONSTRAINT [FK_venta_Empleados]
GO
/****** Object:  StoredProcedure [dbo].[RegistrarVenta]    Script Date: 2/04/2024 15:09:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

    
CREATE PROCEDURE [dbo].[RegistrarVenta]
    @id_venta INT,
    @id_detalle INT,
    @id_producto INT,
    @cantidad INT
AS
BEGIN
    -- Registrar la venta en detalle_venta
    INSERT INTO detalle_venta (id_detalle, id_venta, id_producto, cantidad)
    VALUES (@id_detalle, @id_venta, @id_producto, @cantidad);

    -- Actualizar la cantidad_existente en la tabla producto
    UPDATE productos
    SET existencia = existencia - @cantidad
    WHERE id_producto = @id_producto;

    -- Actualizar la cantidad en el inventario
    UPDATE inventario
    SET cantidad_stock = cantidad_stock - @cantidad
    WHERE id_producto = @id_producto;
END;
GO
USE [master]
GO
ALTER DATABASE [EnaCristina] SET  READ_WRITE 
GO
